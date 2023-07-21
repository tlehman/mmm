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

(def z3-set #{:e :a :b})

(def z3-table {[:e :e] :e
               [:e :a] :a
               [:a :e] :a
               [:e :b] :b
               [:b :e] :b
               [:a :b] :e
               [:b :a] :e
               [:a :a] :b
               [:b :b] :a})

(defn table-to-op [table]
  (fn [a b]
    (table [a b])))

(def z3* (table-to-op z3-table))

(z3* :a :b)


;; Learning protocols and applying them to this project
(defprotocol AlgebraicStructure
  "Alebgraic structures are pairs (A, "
  (elems [a]) ;; Returns a nonempty set of elements
  (id [a])    ;; An identity element (can be nil for semigroups)
  (op [a]))   ;; Returns a binary operation (fn [x y])

(deftype Group [g-set g-op g-id]
  AlgebraicStructure
  (elems [g] g-set)
  (id [g] g-id)
  (op [g] g-op))

(def G
  (Group. z3-set  ;; set of elements
          z3* ;; op : ℤ₃xℤ₃→ℤ₃
          :e) ;; identity = [0] (adding 0 is identity)
  )


(id G)
:e

(elems G)
#{:e :b :a}


(let [*g (op G)]
  (*g :a :b)) ;; a is the inverse of b so
:e            ;; a * b = e (identity)





