(ns sql-injection-example.core
    (:require [clojure.java.jdbc :as jdbc]))

(def db-spec
    {:subprotocol "mysql"
        :subname "//localhost:3306/testdb"
        :user "root"
        :password "password"})

(defn unsafe-query [username]
  (jdbc/query db-spec [(str "SELECT * FROM users WHERE username = '" username "';")]))

(defn -main [& args]
    (let [username (first args)]
        (println (unsafe-query username))))

;; Example usage: (unsafe-query "' OR '1'='1")