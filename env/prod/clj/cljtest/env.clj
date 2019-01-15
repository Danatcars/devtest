(ns cljtest.env
  (:require [clojure.tools.logging :as log]))

(def defaults
  {:init
   (fn []
     (log/info "\n-=[cljtest started successfully]=-"))
   :stop
   (fn []
     (log/info "\n-=[cljtest has shut down successfully]=-"))
   :middleware identity})
