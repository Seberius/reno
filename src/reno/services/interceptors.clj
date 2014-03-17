(ns reno.services.interceptors
  (:require [clojure.core.async :as async]
            [reno.io.cassandra :as cass]))

(defmulti query :db)
(defmethod query :cassandra [message]
  (cass/query message))
