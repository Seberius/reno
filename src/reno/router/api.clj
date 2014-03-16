 (ns reno.router.api
  (:require [compojure.core :refer :all]
            [compojure.route :as route]
            [taoensso.sente :as sente]
            [reno.io.sockets :as sckt]
            [reno.router.handlers :as hdlr]
            [reno.render :as rndr]))

(defroutes app
  (GET "/" req (hdlr/index)))

(defroutes admin
  (GET "/admin" req (hdlr/admin req)))

(defroutes io
  (GET "/io" req (#'sckt/app-get req))
  (POST "/io" req (#'sckt/app-post req))
  (GET "/admin/io" req (#'sckt/admin-get req))
  (POST "/admin/io" req (#'sckt/admin-post req)))

;Starts the handlers for the socket receiving channels [app-recv admin-recv]
(sente/start-chsk-router-loop! hdlr/io-recv-app sckt/app-recv)
(sente/start-chsk-router-loop! hdlr/io-recv-admin sckt/admin-recv)
