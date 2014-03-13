(ns reno.render
  (:require [hiccup.core :as html5]))

(defn index [params]
  (html5/html
   [:div#main
    [:h1 (str (:meeting params))]]))
