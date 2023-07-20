(ns mmm.grp)

;; Groups
;; a group is a pair (G, *) where:
;;      G is a non-empty set and
;;      * is a function * : G x G -> G
;; and
;;      there is a special e in G such that e * a = a * e = a   (identity)
;;      for every a in G, there is a b in G such that a * b = e (inverses)
;;      

;; Example: ℤ₃ is a three element group, it can be defined by it's Cayley table:
;;
;;      * | e a b
;;     ----------
;;      e | e a b
;;      a | a b e
;;      b | b e a
;;
;; We can straightforwardly convert the Cayley table into a map, then make a function
;; that converts the map into an operation, which is a binary function taking pairs of
;; elements of a set back to the same set, so G x G -> G

(def ℤ₃ #{:e :a :b})

(def ℤ₃-table {[:e :e] :e
               [:e :a] :a
               [:a :e] :a
               [:e :b] :b
               [:b :e] :b
               [:a :b] :e
               [:b :a] :e
               [:a :a] :b
               [:b :b] :a})
#'mmm.grp/ℤ₃-table

(defn table-to-op [table]
  (fn [a b]
    (table [a b])))

(def z3* (table-to-op ℤ₃-table))

(z3* :e :a)

