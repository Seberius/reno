(ns reno.config)

(def databases
  {:cassandra
   {:clusters [{:contact-points ["127.0.0.1"]
                :port 9180}]
    :keyspaces ["app"]}})
