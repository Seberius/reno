(ns reno.channels
  (:require [clojure.core.async :as async :refer [<! >! chan go]]))

(def new-messages (chan))
(def cassandra-query (chan))
