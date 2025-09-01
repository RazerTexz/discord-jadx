package com.discord.i18n;

import android.view.View;
import androidx.annotation.ColorInt;
import b.a.k.Hook2;
import d0.z.d.Intrinsics3;
import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function2;

/* compiled from: Hook.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010!\n\u0002\b\u0005\n\u0002\u0010\r\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\n\u0018\u00002\u00020\u0001:\u0001\u0003B\u0007¢\u0006\u0004\b\u0018\u0010\u0019R\u001f\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\u00010\u00028\u0006@\u0006¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006R$\u0010\u000f\u001a\u0004\u0018\u00010\b8\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\t\u0010\n\u001a\u0004\b\u000b\u0010\f\"\u0004\b\r\u0010\u000eR$\u0010\u0017\u001a\u0004\u0018\u00010\u00108\u0000@\u0000X\u0080\u000e¢\u0006\u0012\n\u0004\b\u0011\u0010\u0012\u001a\u0004\b\u0013\u0010\u0014\"\u0004\b\u0015\u0010\u0016¨\u0006\u001a"}, d2 = {"Lcom/discord/i18n/Hook;", "", "", "a", "Ljava/util/List;", "getStyles", "()Ljava/util/List;", "styles", "", "b", "Ljava/lang/CharSequence;", "getReplacementText", "()Ljava/lang/CharSequence;", "setReplacementText", "(Ljava/lang/CharSequence;)V", "replacementText", "Lcom/discord/i18n/Hook$a;", "c", "Lcom/discord/i18n/Hook$a;", "getClickHandler$i18n_release", "()Lcom/discord/i18n/Hook$a;", "setClickHandler$i18n_release", "(Lcom/discord/i18n/Hook$a;)V", "clickHandler", "<init>", "()V", "i18n_release"}, k = 1, mv = {1, 4, 2})
/* loaded from: classes.dex */
public final class Hook {

    /* renamed from: a, reason: from kotlin metadata */
    public final List<Object> styles = new ArrayList();

    /* renamed from: b, reason: collision with root package name and from kotlin metadata */
    public CharSequence replacementText;

    /* renamed from: c, reason: from kotlin metadata */
    public a clickHandler;

    /* compiled from: Hook.kt */
    public static final class a {

        @ColorInt
        public Integer a;

        /* renamed from: b, reason: collision with root package name */
        public Function2<? super String, ? super View, Unit> f2709b;

        public a(@ColorInt Integer num, Function2<? super String, ? super View, Unit> function2) {
            Intrinsics3.checkNotNullParameter(function2, "onClick");
            this.f2709b = Hook2.j;
            this.a = num;
            this.f2709b = function2;
        }
    }
}
