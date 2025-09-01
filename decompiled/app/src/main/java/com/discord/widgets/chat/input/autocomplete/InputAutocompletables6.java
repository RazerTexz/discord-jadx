package com.discord.widgets.chat.input.autocomplete;

import d0.t.Iterables2;
import d0.t.Sets5;
import d0.z.d.Intrinsics3;
import java.util.List;
import java.util.Map;
import java.util.TreeSet;
import kotlin.Metadata;

/* compiled from: InputAutocompletables.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000$\n\u0002\u0010%\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010$\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010 \n\u0002\b\u0003\u001a?\u0010\u0005\u001a\u00020\u0006*\u0014\u0012\u0004\u0012\u00020\u0001\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00030\u00020\u00002\u0018\u0010\u0005\u001a\u0014\u0012\u0004\u0012\u00020\u0001\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00030\u00020\u0004H\u0002¢\u0006\u0004\b\u0005\u0010\u0007\u001a)\u0010\t\u001a\b\u0012\u0004\u0012\u00020\u00030\b*\u0014\u0012\u0004\u0012\u00020\u0001\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00030\b0\u0004¢\u0006\u0004\b\t\u0010\n¨\u0006\u000b"}, d2 = {"", "Lcom/discord/widgets/chat/input/autocomplete/LeadingIdentifier;", "Ljava/util/TreeSet;", "Lcom/discord/widgets/chat/input/autocomplete/Autocompletable;", "", "merge", "", "(Ljava/util/Map;Ljava/util/Map;)V", "", "flatten", "(Ljava/util/Map;)Ljava/util/List;", "app_productionGoogleRelease"}, k = 2, mv = {1, 4, 2})
/* renamed from: com.discord.widgets.chat.input.autocomplete.InputAutocompletablesKt, reason: use source file name */
/* loaded from: classes2.dex */
public final class InputAutocompletables6 {
    public static final /* synthetic */ void access$merge(Map map, Map map2) {
        merge(map, map2);
    }

    public static final List<Autocompletable> flatten(Map<LeadingIdentifier, ? extends List<? extends Autocompletable>> map) {
        Intrinsics3.checkNotNullParameter(map, "$this$flatten");
        return Iterables2.flatten(map.values());
    }

    private static final void merge(Map<LeadingIdentifier, TreeSet<Autocompletable>> map, Map<LeadingIdentifier, ? extends TreeSet<Autocompletable>> map2) {
        for (LeadingIdentifier leadingIdentifier : map2.keySet()) {
            TreeSet<Autocompletable> treeSet = map.get(leadingIdentifier);
            if (treeSet == null) {
                treeSet = new TreeSet<>(new AutocompletableComparator());
                map.put(leadingIdentifier, treeSet);
            }
            TreeSet<Autocompletable> treeSet2 = treeSet;
            TreeSet<Autocompletable> treeSetEmptySet = map2.get(leadingIdentifier);
            if (treeSetEmptySet == null) {
                treeSetEmptySet = Sets5.emptySet();
            }
            treeSet2.addAll(treeSetEmptySet);
        }
    }
}
