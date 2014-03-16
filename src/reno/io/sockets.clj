(ns reno.sockets
  (:require [taoensso.sente :as sente]))

(def app-socket (sente/make-channel-socket! {}))
(def app-post (:ajax-post-fn app-socket))
(def app-get (:ajax-get-or-ws-handshake-fn app-socket))
(def app-recv (:ch-recv app-socket))
(def app-send! (:send-fn app-socket))

(def admin-socket (sente/make-channel-socket! {}))
(def admin-post (:ajax-post-fn admin-socket))
(def admin-get (:ajax-get-or-ws-handshake-fn admin-socket))
(def admin-recv (:ch-recv admin-socket))
(def admin-send! (:send-fn admin-socket))
