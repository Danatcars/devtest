(ns user
  (:require [luminus-migrations.core :as migrations]
            [cljtest.config :refer [env]]
            [mount.core :as mount]
            [cljtest.core :refer [start-app]]))

(defn start []
  (mount/start-without #'cljtest.core/repl-server))

(defn stop []
  (mount/stop-except #'cljtest.core/repl-server))

(defn restart []
  (stop)
  (start))

(defn migrate []
  (migrations/migrate ["migrate"] (select-keys env [:database-url])))

(defn rollback []
  (migrations/migrate ["rollback"] (select-keys env [:database-url])))

(defn create-migration [name]
  (migrations/create name (select-keys env [:database-url])))


