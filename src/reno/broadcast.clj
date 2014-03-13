(ns reno.broadcast
  (:require [reno.channels :as chan]))

;App message broadcast service
(go-loop [message (<! chan/app-message)
          dest (:dest message)]
  (match [dest]
    [:all]
      (io/app-send! :all message)
    [uid]
      (io/app-send! uid message)))

