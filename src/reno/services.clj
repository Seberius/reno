(ns reno.services
  (:require [reno.channels :as chan]))

(def
  (go-loop [message (<! chan/new-messages)]))
