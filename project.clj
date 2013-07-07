(defproject chp "0.1.0-SNAPSHOT"
  :description "FIXME: write description"
  :url "http://example.com/FIXME"
  :dependencies [[org.clojure/clojure "1.5.1"]
                 [compojure "1.1.5"]
                 [hiccup "1.0.3"]
                 [garden "0.1.0-beta4"]
                 [korma "0.3.0-RC5"]
                 [lib-noir "0.6.4"]
                 [lobos "1.0.0-beta1"]
                 [org.postgresql/postgresql "9.2-1003-jdbc4"]]
  :plugins [[lein-ring "0.8.3"]
            [lein-cljsbuild "0.3.1"]]
  :ring {:port 8000
         :auto-reload? true
         :auto-refresh? true
         :reload-paths ["src/chp/"
                        "chp-root/"
                        "resources/middleware/"]
         :handler chp.handler/app}
  :aliases {"schema" ["run" "-m" "chp.schema/load-schemas"]
            "migrate" ["run" "-m" "chp.migration/chp-migrate"]
            "rollback" ["run" "-m" "chp.migration/chp-rollback"]
            "gen" ["run" "-m" "chp.generator/builder->gen"]
            "chp-clean" ["run" "-m" "chp.clean/clean"]}
  :cljsbuild {:builds [{:source-paths ["resources/cljs"]
                        :compiler {:output-to "resources/public/js/main.js"
                                   :optimizations :advanced
                                   :pretty-print true}}]}
  :profiles {:dev {:dependencies [[ring-mock "0.1.3"]]}})
