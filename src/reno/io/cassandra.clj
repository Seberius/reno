(ns reno.io.cassandra
  (:require [clojurewerkz.cassaforte.client :as client]
            [clojurewerkz.cassaforte.multi.cql :as cql]
            [clojurewerkz.cassaforte.query :refer :all]
            [reno.io.channels :as chan]))

(def ^{:private true} cluster-app (client/build-cluster {:contact-points ["127.0.0.1"]
                                                         :port 9000}))
(def ^{:private true} session-app (client/connect cluster-app :app))

(defn- select [data] (let [{:keys uid} data]
                       (cql/select (:type data) {:uid uid})))
(defn- create [data] (let [{:keys uid title body} data]
                       (cql/insert (:type data) {:uid uid
                                                 :title title
                                                 :body body})))
(defn- update [data] (let [{:keys uid} data]
                       (cql/update (:type data) {})))
(defn- delete [data] (let [{:keys uid} data]
                       (cql/delete (:type data) {})))
(defn- cass-count [data] (let [{:keys uid} data]
                           (cql/count (:type data) {})))

(defmulti query :action)
(defmethod query :select [message]
  (client/execute (select (:data message))))
(defmethod query :create [message]
  (client/execute (create (:data message))))
(defmethod query :update [message]
  (client/execute (update (:data message))))
(defmethod query :delete [message]
  (client/execute (update (:data message))))
(defmethod query :count [message]
  (client/execute (cass-count (:data message))))
