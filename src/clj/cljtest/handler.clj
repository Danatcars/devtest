(ns cljtest.handler
  (:require [compojure.core :refer [routes wrap-routes]]
            [cljtest.layout :refer [error-page]]
            [cljtest.routes.home :refer [home-routes]]
            [cljtest.routes.view-vehicle :refer [view-vehicle-routes]]
            [compojure.route :as route]
            [cljtest.env :refer [defaults]]
            [mount.core :as mount]
            [cljtest.middleware :as middleware]))

(mount/defstate init-app
  :start ((or (:init defaults) identity))
  :stop  ((or (:stop defaults) identity)))

(mount/defstate app
  :start
  (middleware/wrap-base
    (routes
     (-> (routes #'view-vehicle-routes #'home-routes)
          (wrap-routes middleware/wrap-csrf)
          (wrap-routes middleware/wrap-formats))
      (route/not-found
        (:body
          (error-page {:status 404
                       :title "page not found"}))))))
