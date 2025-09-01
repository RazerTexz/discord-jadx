package com.discord.utilities.fragment;

import android.os.Bundle;
import androidx.fragment.app.Fragment;
import com.discord.models.domain.ModelAuditLogEntry;
import d0.LazyJVM;
import d0.z.d.Intrinsics3;
import d0.z.d.Lambda;
import kotlin.Lazy;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;

/* compiled from: FragmentExtensions.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\u001a)\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00030\u0005*\u00020\u00002\u0006\u0010\u0002\u001a\u00020\u00012\b\b\u0002\u0010\u0004\u001a\u00020\u0003¢\u0006\u0004\b\u0006\u0010\u0007¨\u0006\b"}, d2 = {"Landroidx/fragment/app/Fragment;", "", ModelAuditLogEntry.CHANGE_KEY_NAME, "", "defaultValue", "Lkotlin/Lazy;", "booleanExtra", "(Landroidx/fragment/app/Fragment;Ljava/lang/String;Z)Lkotlin/Lazy;", "utils_release"}, k = 2, mv = {1, 4, 2})
/* renamed from: com.discord.utilities.fragment.FragmentExtensionsKt, reason: use source file name */
/* loaded from: classes2.dex */
public final class FragmentExtensions {

    /* compiled from: FragmentExtensions.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\b\n\u0002\u0010\u000b\n\u0002\b\u0003\u0010\u0003\u001a\u00020\u0000H\n¢\u0006\u0004\b\u0001\u0010\u0002"}, d2 = {"", "invoke", "()Z", "<anonymous>"}, k = 3, mv = {1, 4, 2})
    /* renamed from: com.discord.utilities.fragment.FragmentExtensionsKt$booleanExtra$1, reason: invalid class name */
    public static final class AnonymousClass1 extends Lambda implements Function0<Boolean> {
        public final /* synthetic */ boolean $defaultValue;
        public final /* synthetic */ String $name;
        public final /* synthetic */ Fragment $this_booleanExtra;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public AnonymousClass1(Fragment fragment, String str, boolean z2) {
            super(0);
            this.$this_booleanExtra = fragment;
            this.$name = str;
            this.$defaultValue = z2;
        }

        @Override // kotlin.jvm.functions.Function0
        public /* bridge */ /* synthetic */ Boolean invoke() {
            return Boolean.valueOf(invoke2());
        }

        /* renamed from: invoke, reason: avoid collision after fix types in other method */
        public final boolean invoke2() {
            Bundle arguments = this.$this_booleanExtra.getArguments();
            return arguments != null ? arguments.getBoolean(this.$name, this.$defaultValue) : this.$defaultValue;
        }
    }

    public static final Lazy<Boolean> booleanExtra(Fragment fragment, String str, boolean z2) {
        Intrinsics3.checkNotNullParameter(fragment, "$this$booleanExtra");
        Intrinsics3.checkNotNullParameter(str, ModelAuditLogEntry.CHANGE_KEY_NAME);
        return LazyJVM.lazy(new AnonymousClass1(fragment, str, z2));
    }

    public static /* synthetic */ Lazy booleanExtra$default(Fragment fragment, String str, boolean z2, int i, Object obj) {
        if ((i & 2) != 0) {
            z2 = false;
        }
        return booleanExtra(fragment, str, z2);
    }
}
