(ns cljtest.env
  (:require [selmer.parser :as parser]
            [clojure.tools.logging :as log]
            [cljtest.dev-middleware :refer [wrap-dev]]))

(def defaults
  {:init
   (fn []
     (parser/cache-off!)
     (log/info "\n-=[cljtest started successfully using the development profile]=-"))
   :stop
   (fn []
     (log/info "\n-=[cljtest has shut down successfully]=-"))
   :middleware wrap-dev})
