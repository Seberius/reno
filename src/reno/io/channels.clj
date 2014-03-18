(ns reno.io.channels
  (:require [clojure.core.async :as async]))

(def new-messages (async/chan))
(def cassandra-query (async/chan))
