(ns reno.io.cassandra
  (:require [clojurewerkz.cassaforte.client :as client]
            [clojurewerkz.cassaforte.multi.cql :refer :all]
            [clojurewerkz.cassaforte.query :refer :all]
            [reno.io.channels :as chan]))

(def cluster-app (client/build-cluster {:contact-points ["127.0.0.1"]
                                        :port 9000}))
(def session-app (client/connect cluster-app :app))

(def query-message-insert (client/prepared
                           (insert :meetings {})))

(defn query-service []
  (go (while true
        (let [message (<! chan/cassandra-query)
              {:keys query-type uid author date data} message]
          (match query-type

                 [:create]
                 (client/execute)

                 [:delete]
                 (client/execute))))))
