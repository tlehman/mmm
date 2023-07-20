
# The Monoidal Monastery of Mathematics

This is a Clojure repo for exploring mathematics with the intention of doing so
in [Roam Research](https://roamresearch.com).

The code will be written here first, in Emacs, using Cider, and then ported to
the ClojureScript environment embedded in Roam.

## wtf is a monoid

A **monoid** a non-empty set $M$ together with a binary associative operation $* : M \times M \to M$,
and there is on special element $e \in M$ that doesn't change under the operation, so for every $a \in M$, it's the case that $e * a = e * a = a$.

In [grp.clj](src/mmm/grp.clj) you will see a definition of a **group**. If you know what a monoid is,
then a group is just a monoid with inverses. So for every $a \in G$, there is a $b \in G$ such that
$a * b = b * a = e$. 

## Usage

```shell
lein repl
```

And then use `cider-connect` in Emacs to connect to the repl and eval your code in the buffer.

## License

Copyright © 2023 FIXME

This program and the accompanying materials are made available under the
terms of the Eclipse Public License 2.0 which is available at
http://www.eclipse.org/legal/epl-2.0.

This Source Code may also be made available under the following Secondary
Licenses when the conditions for such availability set forth in the Eclipse
Public License, v. 2.0 are satisfied: GNU General Public License as published by
the Free Software Foundation, either version 2 of the License, or (at your
option) any later version, with the GNU Classpath Exception which is available
at https://www.gnu.org/software/classpath/license.html.
