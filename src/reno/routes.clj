(ns reno.routes
  (:require [compojure.core :refer :all]
            [compojure.route :as route]
            [reno.io :as io]
            [reno.render :as render]))

(defroutes app
  (GET "/" [] "<h1>Hello Reno!</h1>")
  (GET "/:meeting" [meeting] (render/index {:meeting meeting})))

(defroutes websocket
  (GET "/appchan" req (#'io/app-get req))
  (POST "/appchan" req (#'io/app-post req)))
