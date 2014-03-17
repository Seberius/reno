(ns reno.io.cassandra
  (:require [clojurewerkz.cassaforte.client :as client]
            [clojurewerkz.cassaforte.multi.cql :refer :all]
            [clojurewerkz.cassaforte.query :refer :all]
            [reno.io.channels :as chan]))

(def ^{:private true} cluster-app (client/build-cluster {:contact-points ["127.0.0.1"]
                                                         :port 9000}))
(def ^{:private true} session-app (client/connect cluster-app :app))
(def ^{:private true} query-message-insert (client/prepared
                                            (insert :meetings {})))

(defmulti query :action)
(defmethod query :create [message]
  (client/execute))
(defmethod query :update [message]
  (client/execute))
(defmethod query :delete [message]
  (client/execute))
