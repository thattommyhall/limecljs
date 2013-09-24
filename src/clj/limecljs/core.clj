(ns limecljs.core
  (:use [compojure.core]
        [hiccup.core])
  (:require [compojure.handler :as handler]
            [compojure.route :as route]
            [ring.util.response :refer [header]]
            [clojure.data.json :as json]
            [clojure.string :as string]))

(defroutes site-routes
  (GET "/" []
       (html [:head {:title "test"}
              [:link {:rel "stylesheet" :href "css/style.css"}]
              [:script {:src "js/dev.js"}]]
             [:body
              {:onload "limecljs.core.init()"}
              ]))
  (route/resources "/")
  (route/not-found "Page not found"))

(def app (handler/site site-routes))
