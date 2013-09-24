(defproject enlil "0.1.0-SNAPSHOT"
  :description "FIXME: write description"
  :url "http://example.com/FIXME"
  :license {:name "Eclipse Public License"
            :url "http://www.eclipse.org/legal/epl-v10.html"}
  :dependencies [[org.clojure/clojure "1.5.1"]
                 [org.clojure/clojurescript "0.0-1889"]
                 [compojure "1.1.5"]
                 [hiccup "1.0.4"]
                 [org.clojars.magomimmo/domina "1.0.2-SNAPSHOT"]
                 [org.clojure/data.json "0.2.3"]
                 [com.wagjo/closure-library "0.1.0-SNAPSHOT"]
                 ;; [org.clojure/google-closure-library "0.1.0-SNAPSHOT"]
                 ;; [org.clojure/google-closure-library-third-party "0.0-2029"]
                 ]
  :source-paths ["src/clj"]

  :plugins [[lein-cljsbuild "0.3.3"]
            [lein-ring "0.8.7"]]

  :ring {:handler limecljs.core/app}

  :cljsbuild {:builds {:dev
                       {:source-paths ["src/brepl" "src/cljs"]
                        :compiler {:output-to "resources/public/js/dev.js"
                                   :optimizations :whitespace
                                   :pretty-print true}}

                       :prod
                       {:source-paths ["src/cljs"]
                        :compiler {:output-to "resources/public/js/prod.js"
                                   :optimizations :advanced}}
                       }}


  )
