(defproject reno "0.0.0-ALPHA"
  :description "Reno: A small web app for listing a meetup group's schedule and info"
  :url "http://reno.seberius.com"
  :license {:name "Eclipse Public License"
            :url "http://www.eclipse.org/legal/epl-v10.html"}

  :dependencies [[org.clojure/clojure "1.5.1"]
                 [org.clojure/core.async "0.1.278.0-76b25b-alpha"]
                 [org.clojure/clojurescript "0.0-2173"]
                 [http-kit "2.1.17"]
                 [ring "1.2.2"]
                 [com.taoensso/sente "0.8.2"]
                 [compojure "1.1.6"]
                 [hiccup "1.0.5"]
                 [ring-anti-forgery "0.3.0"]
                 [com.taoensso/timbre "3.1.6"]
                 [om "0.5.2"]
                 [sablono "0.2.10"]]

  :plugins [[lein-cljsbuild "1.0.2"]]

  :cljsbuild {
    :builds [{:id "reno"
              :source-paths ["src-cljs"]
              :compiler {
                :output-to "reno.js"
                :output-dir "out"
                :optimizations :none
                :source-map true}}]})
