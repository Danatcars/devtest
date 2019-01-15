(ns cljtest.routes.view-vehicle
  (:require [cljtest.db.core :as db]
            [cljtest.layout :as layout]
            [compojure.core :refer [defroutes GET]]
            [cljtest.db.core :as db]))

(defn view-vehicle []
  (let [data (db/vehicle-by-id {:id 186})]
    (layout/render "view-vehicle.html" {:data data})))

(defroutes view-vehicle-routes
  (GET "/for-sale/" [] (view-vehicle)))
