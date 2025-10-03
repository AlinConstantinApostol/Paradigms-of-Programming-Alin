# Prelucrare funcțională a unei liste (filter → chunk → map → reduce)

## Descriere
Se aplică operații funcționale pe lista `[1, 21, 75, 39, 7, 2, 35, 3, 31, 7, 8]`:
1. Se elimină elementele mai mici decât 5.
2. Se grupează elementele rămase în perechi consecutive.
3. Se înmulesc elementele din fiecare pereche.
4. Se însumează produsele obținute.

Rezultatul final: `2989`.

## Algoritm (pași)
- `filter` — păstrează doar elementele `>= 5`.
- `chunk` (implementat ca slicing în pași de 2) — construiește perechi `(a, b)`.
- `map` — calculează produsul pentru fiecare pereche.
- `reduce` — însumează toate produsele.

## Fișier
`main.py` — conține implementarea în Python (folosind `filter`, `map`, `reduce` și list comprehensions).

Exemplu de cod (implementare folosită):
```python
from functools import reduce

l = [1, 21, 75, 39, 7, 2, 35, 3, 31, 7, 8]
l = list(filter(lambda x: x >= 5, l))
l = map(lambda pair: pair[0] * pair[1],
                    [l[i:i + 2] for i in range(0, len(l), 2)
                     if i + 1 < len(l)])
l = reduce(lambda acc, x: acc + x, l, 0)

print(l)

