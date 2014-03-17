(ns reno.services.broadcast
  (:require [reno.io.channels :as chan]
            [reno.io.sockets :as sckt]))

(defn app-event [message]
  (let [{:keys recv type data} message]
    (sckt/app-send! recv [(keyword type) data])))

