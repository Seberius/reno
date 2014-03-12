(ns reno.routes
  (:require [compojure.core :refer :all]
            [compojure.route :as route]
            [reno.io :as io]))

(defroutes app
  (GET "/" [] "<h1>Hello Reno!</h1>")
  (GET "/:meeting" [meeting] (str "Meeting: " meeting))
  (GET "/:meeting/comments" [meeting] (str "Meeting: " meeting "/n"
                                           "Comment: This meeting is great."))
  (POST "/:meeting/comments" [meeting github-id body] (str "Meeting: " meeting "/n"
                                                           "Comment: This meeting is great./n"
                                                           github-id ": " body)))

(defroutes websocket
  (GET "/appchan" req (#'io/app-get req))
  (POST "/appchan" req (#'io/app-post req)))
