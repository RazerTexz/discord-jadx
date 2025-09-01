package com.franmontiel.persistentcookiejar.cache;

import f0.Cookie;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

/* loaded from: classes3.dex */
public class SetCookieCache implements CookieCache {
    public Set<IdentifiableCookie> j = new HashSet();

    public class SetCookieCacheIterator implements Iterator<Cookie> {
        public Iterator<IdentifiableCookie> j;

        public SetCookieCacheIterator(SetCookieCache setCookieCache) {
            this.j = setCookieCache.j.iterator();
        }

        @Override // java.util.Iterator
        public boolean hasNext() {
            return this.j.hasNext();
        }

        @Override // java.util.Iterator
        public Cookie next() {
            return this.j.next().a;
        }

        @Override // java.util.Iterator
        public void remove() {
            this.j.remove();
        }
    }

    @Override // com.franmontiel.persistentcookiejar.cache.CookieCache
    public void addAll(Collection<Cookie> collection) {
        ArrayList arrayList = new ArrayList(collection.size());
        Iterator<Cookie> it = collection.iterator();
        while (it.hasNext()) {
            arrayList.add(new IdentifiableCookie(it.next()));
        }
        Iterator it2 = arrayList.iterator();
        while (it2.hasNext()) {
            IdentifiableCookie identifiableCookie = (IdentifiableCookie) it2.next();
            this.j.remove(identifiableCookie);
            this.j.add(identifiableCookie);
        }
    }

    @Override // java.lang.Iterable
    public Iterator<Cookie> iterator() {
        return new SetCookieCacheIterator(this);
    }
}
