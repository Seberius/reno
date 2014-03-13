(ns reno.io
  (:require [taoensso.sente :as sente :refer (cb-success?)]))

(let [{:keys [ch-recv send-fn ajax-post-fn ajax-get-or-ws-handshake-fn]}
      (sente/make-channel-socket! {})]
  (def app-post ajax-post-fn)
  (def app-get ajax-get-or-ws-handshake-fn)
  (def app-recv ch-recv)
  (def app-send! send-fn))
