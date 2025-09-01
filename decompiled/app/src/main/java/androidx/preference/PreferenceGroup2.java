package androidx.preference;

import androidx.exifinterface.media.ExifInterface;
import b.d.b.a.outline;
import d0.z.d.Intrinsics3;
import d0.z.d.g0.KMarkers;
import java.util.Iterator;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.sequences.Sequence;

/* compiled from: PreferenceGroup.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000J\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\r\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010)\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\u001a(\u0010\u0005\u001a\u0004\u0018\u00018\u0000\"\b\b\u0000\u0010\u0001*\u00020\u0000*\u00020\u00022\u0006\u0010\u0004\u001a\u00020\u0003H\u0086\n¢\u0006\u0004\b\u0005\u0010\u0006\u001a\u001c\u0010\u0005\u001a\u00020\u0000*\u00020\u00022\u0006\u0010\b\u001a\u00020\u0007H\u0086\u0002¢\u0006\u0004\b\u0005\u0010\t\u001a\u001c\u0010\f\u001a\u00020\u000b*\u00020\u00022\u0006\u0010\n\u001a\u00020\u0000H\u0086\u0002¢\u0006\u0004\b\f\u0010\r\u001a\u001c\u0010\u000f\u001a\u00020\u000e*\u00020\u00022\u0006\u0010\n\u001a\u00020\u0000H\u0086\n¢\u0006\u0004\b\u000f\u0010\u0010\u001a\u001c\u0010\u0011\u001a\u00020\u000e*\u00020\u00022\u0006\u0010\n\u001a\u00020\u0000H\u0086\n¢\u0006\u0004\b\u0011\u0010\u0010\u001a\u0014\u0010\u0012\u001a\u00020\u000b*\u00020\u0002H\u0086\b¢\u0006\u0004\b\u0012\u0010\u0013\u001a\u0014\u0010\u0014\u001a\u00020\u000b*\u00020\u0002H\u0086\b¢\u0006\u0004\b\u0014\u0010\u0013\u001a(\u0010\u0017\u001a\u00020\u000e*\u00020\u00022\u0012\u0010\u0016\u001a\u000e\u0012\u0004\u0012\u00020\u0000\u0012\u0004\u0012\u00020\u000e0\u0015H\u0086\b¢\u0006\u0004\b\u0017\u0010\u0018\u001a.\u0010\u001a\u001a\u00020\u000e*\u00020\u00022\u0018\u0010\u0016\u001a\u0014\u0012\u0004\u0012\u00020\u0007\u0012\u0004\u0012\u00020\u0000\u0012\u0004\u0012\u00020\u000e0\u0019H\u0086\b¢\u0006\u0004\b\u001a\u0010\u001b\u001a\u001a\u0010\u001d\u001a\b\u0012\u0004\u0012\u00020\u00000\u001c*\u00020\u0002H\u0086\u0002¢\u0006\u0004\b\u001d\u0010\u001e\"\u001d\u0010\"\u001a\b\u0012\u0004\u0012\u00020\u00000\u001f*\u00020\u00028F@\u0006¢\u0006\u0006\u001a\u0004\b \u0010!\"\u0018\u0010%\u001a\u00020\u0007*\u00020\u00028Æ\u0002@\u0006¢\u0006\u0006\u001a\u0004\b#\u0010$¨\u0006&"}, d2 = {"Landroidx/preference/Preference;", ExifInterface.GPS_DIRECTION_TRUE, "Landroidx/preference/PreferenceGroup;", "", "key", "get", "(Landroidx/preference/PreferenceGroup;Ljava/lang/CharSequence;)Landroidx/preference/Preference;", "", "index", "(Landroidx/preference/PreferenceGroup;I)Landroidx/preference/Preference;", "preference", "", "contains", "(Landroidx/preference/PreferenceGroup;Landroidx/preference/Preference;)Z", "", "plusAssign", "(Landroidx/preference/PreferenceGroup;Landroidx/preference/Preference;)V", "minusAssign", "isEmpty", "(Landroidx/preference/PreferenceGroup;)Z", "isNotEmpty", "Lkotlin/Function1;", "action", "forEach", "(Landroidx/preference/PreferenceGroup;Lkotlin/jvm/functions/Function1;)V", "Lkotlin/Function2;", "forEachIndexed", "(Landroidx/preference/PreferenceGroup;Lkotlin/jvm/functions/Function2;)V", "", "iterator", "(Landroidx/preference/PreferenceGroup;)Ljava/util/Iterator;", "Lkotlin/sequences/Sequence;", "getChildren", "(Landroidx/preference/PreferenceGroup;)Lkotlin/sequences/Sequence;", "children", "getSize", "(Landroidx/preference/PreferenceGroup;)I", "size", "preference-ktx_release"}, k = 2, mv = {1, 4, 0})
/* renamed from: androidx.preference.PreferenceGroupKt, reason: use source file name */
/* loaded from: classes.dex */
public final class PreferenceGroup2 {

    /* compiled from: PreferenceGroup.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000%\n\u0000\n\u0002\u0010)\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0003*\u0001\u0000\b\n\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001J\u0010\u0010\u0004\u001a\u00020\u0003H\u0096\u0002¢\u0006\u0004\b\u0004\u0010\u0005J\u0010\u0010\u0006\u001a\u00020\u0002H\u0096\u0002¢\u0006\u0004\b\u0006\u0010\u0007J\u000f\u0010\t\u001a\u00020\bH\u0016¢\u0006\u0004\b\t\u0010\nR\u0016\u0010\f\u001a\u00020\u000b8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\f\u0010\r¨\u0006\u000e"}, d2 = {"androidx/preference/PreferenceGroupKt$iterator$1", "", "Landroidx/preference/Preference;", "", "hasNext", "()Z", "next", "()Landroidx/preference/Preference;", "", "remove", "()V", "", "index", "I", "preference-ktx_release"}, k = 1, mv = {1, 4, 0})
    /* renamed from: androidx.preference.PreferenceGroupKt$iterator$1, reason: invalid class name */
    public static final class AnonymousClass1 implements Iterator<Preference>, KMarkers {
        public final /* synthetic */ PreferenceGroup $this_iterator;
        private int index;

        public AnonymousClass1(PreferenceGroup preferenceGroup) {
            this.$this_iterator = preferenceGroup;
        }

        @Override // java.util.Iterator
        public boolean hasNext() {
            return this.index < this.$this_iterator.getPreferenceCount();
        }

        @Override // java.util.Iterator
        public /* bridge */ /* synthetic */ Preference next() {
            return next();
        }

        @Override // java.util.Iterator
        public void remove() {
            PreferenceGroup preferenceGroup = this.$this_iterator;
            int i = this.index - 1;
            this.index = i;
            preferenceGroup.removePreference(preferenceGroup.getPreference(i));
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // java.util.Iterator
        public Preference next() {
            PreferenceGroup preferenceGroup = this.$this_iterator;
            int i = this.index;
            this.index = i + 1;
            Preference preference = preferenceGroup.getPreference(i);
            if (preference != null) {
                return preference;
            }
            throw new IndexOutOfBoundsException();
        }
    }

    public static final boolean contains(PreferenceGroup preferenceGroup, Preference preference) {
        Intrinsics3.checkParameterIsNotNull(preferenceGroup, "$this$contains");
        Intrinsics3.checkParameterIsNotNull(preference, "preference");
        int preferenceCount = preferenceGroup.getPreferenceCount();
        for (int i = 0; i < preferenceCount; i++) {
            if (Intrinsics3.areEqual(preferenceGroup.getPreference(i), preference)) {
                return true;
            }
        }
        return false;
    }

    public static final void forEach(PreferenceGroup preferenceGroup, Function1<? super Preference, Unit> function1) {
        Intrinsics3.checkParameterIsNotNull(preferenceGroup, "$this$forEach");
        Intrinsics3.checkParameterIsNotNull(function1, "action");
        int preferenceCount = preferenceGroup.getPreferenceCount();
        for (int i = 0; i < preferenceCount; i++) {
            function1.invoke(get(preferenceGroup, i));
        }
    }

    public static final void forEachIndexed(PreferenceGroup preferenceGroup, Function2<? super Integer, ? super Preference, Unit> function2) {
        Intrinsics3.checkParameterIsNotNull(preferenceGroup, "$this$forEachIndexed");
        Intrinsics3.checkParameterIsNotNull(function2, "action");
        int preferenceCount = preferenceGroup.getPreferenceCount();
        for (int i = 0; i < preferenceCount; i++) {
            function2.invoke(Integer.valueOf(i), get(preferenceGroup, i));
        }
    }

    public static final <T extends Preference> T get(PreferenceGroup preferenceGroup, CharSequence charSequence) {
        Intrinsics3.checkParameterIsNotNull(preferenceGroup, "$this$get");
        Intrinsics3.checkParameterIsNotNull(charSequence, "key");
        return (T) preferenceGroup.findPreference(charSequence);
    }

    public static final Sequence<Preference> getChildren(PreferenceGroup preferenceGroup) {
        Intrinsics3.checkParameterIsNotNull(preferenceGroup, "$this$children");
        return new PreferenceGroup3(preferenceGroup);
    }

    public static final int getSize(PreferenceGroup preferenceGroup) {
        Intrinsics3.checkParameterIsNotNull(preferenceGroup, "$this$size");
        return preferenceGroup.getPreferenceCount();
    }

    public static final boolean isEmpty(PreferenceGroup preferenceGroup) {
        Intrinsics3.checkParameterIsNotNull(preferenceGroup, "$this$isEmpty");
        return preferenceGroup.getPreferenceCount() == 0;
    }

    public static final boolean isNotEmpty(PreferenceGroup preferenceGroup) {
        Intrinsics3.checkParameterIsNotNull(preferenceGroup, "$this$isNotEmpty");
        return preferenceGroup.getPreferenceCount() != 0;
    }

    public static final Iterator<Preference> iterator(PreferenceGroup preferenceGroup) {
        Intrinsics3.checkParameterIsNotNull(preferenceGroup, "$this$iterator");
        return new AnonymousClass1(preferenceGroup);
    }

    public static final void minusAssign(PreferenceGroup preferenceGroup, Preference preference) {
        Intrinsics3.checkParameterIsNotNull(preferenceGroup, "$this$minusAssign");
        Intrinsics3.checkParameterIsNotNull(preference, "preference");
        preferenceGroup.removePreference(preference);
    }

    public static final void plusAssign(PreferenceGroup preferenceGroup, Preference preference) {
        Intrinsics3.checkParameterIsNotNull(preferenceGroup, "$this$plusAssign");
        Intrinsics3.checkParameterIsNotNull(preference, "preference");
        preferenceGroup.addPreference(preference);
    }

    public static final Preference get(PreferenceGroup preferenceGroup, int i) {
        Intrinsics3.checkParameterIsNotNull(preferenceGroup, "$this$get");
        Preference preference = preferenceGroup.getPreference(i);
        if (preference != null) {
            return preference;
        }
        StringBuilder sbV = outline.V("Index: ", i, ", Size: ");
        sbV.append(preferenceGroup.getPreferenceCount());
        throw new IndexOutOfBoundsException(sbV.toString());
    }
}
