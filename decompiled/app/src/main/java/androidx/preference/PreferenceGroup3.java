package androidx.preference;

import java.util.Iterator;
import kotlin.Metadata;
import kotlin.sequences.Sequence;

/* compiled from: PreferenceGroup.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0015\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010)\n\u0002\b\u0003*\u0001\u0000\b\n\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001J\u0016\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00020\u0003H\u0096\u0002¢\u0006\u0004\b\u0004\u0010\u0005¨\u0006\u0006"}, d2 = {"androidx/preference/PreferenceGroupKt$children$1", "Lkotlin/sequences/Sequence;", "Landroidx/preference/Preference;", "", "iterator", "()Ljava/util/Iterator;", "preference-ktx_release"}, k = 1, mv = {1, 4, 0})
/* renamed from: androidx.preference.PreferenceGroupKt$children$1, reason: use source file name */
/* loaded from: classes.dex */
public final class PreferenceGroup3 implements Sequence<Preference> {
    public final /* synthetic */ PreferenceGroup $this_children;

    public PreferenceGroup3(PreferenceGroup preferenceGroup) {
        this.$this_children = preferenceGroup;
    }

    @Override // kotlin.sequences.Sequence
    public Iterator<Preference> iterator() {
        return PreferenceGroup2.iterator(this.$this_children);
    }
}
