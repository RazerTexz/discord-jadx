package com.discord.i18n;

import android.view.View;
import androidx.annotation.ColorInt;
import b.a.k.RenderContext2;
import com.discord.i18n.Hook;
import d0.z.d.Intrinsics3;
import d0.z.d.Lambda;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;

/* compiled from: RenderContext.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000F\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0007\n\u0002\u0010\b\n\u0002\b\u0007\n\u0002\u0010%\n\u0002\b\u0004\n\u0002\u0010 \n\u0002\b\u0014\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b4\u00105J)\u0010\b\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\u0012\u0010\u0007\u001a\u000e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u00060\u0004¢\u0006\u0004\b\b\u0010\tJ)\u0010\f\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\u0012\u0010\u000b\u001a\u000e\u0012\u0004\u0012\u00020\n\u0012\u0004\u0012\u00020\u00060\u0004¢\u0006\u0004\b\f\u0010\tR\"\u0010\u0014\u001a\u00020\r8\u0000@\u0000X\u0080\u000e¢\u0006\u0012\n\u0004\b\u000e\u0010\u000f\u001a\u0004\b\u0010\u0010\u0011\"\u0004\b\u0012\u0010\u0013R$\u0010\u001c\u001a\u0004\u0018\u00010\u00158\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u0016\u0010\u0017\u001a\u0004\b\u0018\u0010\u0019\"\u0004\b\u001a\u0010\u001bR%\u0010!\u001a\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00020\u001d8\u0006@\u0006¢\u0006\f\n\u0004\b\f\u0010\u001e\u001a\u0004\b\u001f\u0010 R,\u0010)\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010\u0001\u0018\u00010\"8\u0000@\u0000X\u0080\u000e¢\u0006\u0012\n\u0004\b#\u0010$\u001a\u0004\b%\u0010&\"\u0004\b'\u0010(R$\u0010-\u001a\u0004\u0018\u00010\u00158\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b*\u0010\u0017\u001a\u0004\b+\u0010\u0019\"\u0004\b,\u0010\u001bR\"\u00101\u001a\u00020\r8\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b.\u0010\u000f\u001a\u0004\b/\u0010\u0011\"\u0004\b0\u0010\u0013R(\u00103\u001a\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\n0\u001d8\u0000@\u0000X\u0080\u0004¢\u0006\f\n\u0004\b\b\u0010\u001e\u001a\u0004\b2\u0010 ¨\u00066"}, d2 = {"Lcom/discord/i18n/RenderContext;", "", "", "key", "Lkotlin/Function1;", "Landroid/view/View;", "", "onClick", "b", "(Ljava/lang/String;Lkotlin/jvm/functions/Function1;)V", "Lcom/discord/i18n/Hook;", "hookInitializer", "a", "", "g", "Z", "getHasClickables$i18n_release", "()Z", "setHasClickables$i18n_release", "(Z)V", "hasClickables", "", "e", "Ljava/lang/Integer;", "getStrikethroughColor", "()Ljava/lang/Integer;", "setStrikethroughColor", "(Ljava/lang/Integer;)V", "strikethroughColor", "", "Ljava/util/Map;", "getArgs", "()Ljava/util/Map;", "args", "", "c", "Ljava/util/List;", "getOrderedArguments$i18n_release", "()Ljava/util/List;", "setOrderedArguments$i18n_release", "(Ljava/util/List;)V", "orderedArguments", "d", "getBoldColor", "setBoldColor", "boldColor", "f", "getUppercase", "setUppercase", "uppercase", "getHooks$i18n_release", "hooks", "<init>", "()V", "i18n_release"}, k = 1, mv = {1, 4, 2})
/* loaded from: classes.dex */
public final class RenderContext {

    /* renamed from: a, reason: from kotlin metadata */
    public final Map<String, String> args = new HashMap();

    /* renamed from: b, reason: collision with root package name and from kotlin metadata */
    public final Map<String, Hook> hooks = new HashMap();

    /* renamed from: c, reason: from kotlin metadata */
    public List<? extends Object> orderedArguments;

    /* renamed from: d, reason: from kotlin metadata */
    @ColorInt
    public Integer boldColor;

    /* renamed from: e, reason: from kotlin metadata */
    @ColorInt
    public Integer strikethroughColor;

    /* renamed from: f, reason: from kotlin metadata */
    public boolean uppercase;

    /* renamed from: g, reason: from kotlin metadata */
    public boolean hasClickables;

    /* compiled from: RenderContext.kt */
    public static final class a extends Lambda implements Function1<Hook, Unit> {
        public final /* synthetic */ Function1 $onClick;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public a(Function1 function1) {
            super(1);
            this.$onClick = function1;
        }

        @Override // kotlin.jvm.functions.Function1
        public Unit invoke(Hook hook) {
            Hook hook2 = hook;
            Intrinsics3.checkNotNullParameter(hook2, "$receiver");
            RenderContext2 renderContext2 = new RenderContext2(this);
            Objects.requireNonNull(hook2);
            Intrinsics3.checkNotNullParameter(renderContext2, "onClick");
            hook2.clickHandler = new Hook.a(null, renderContext2);
            return Unit.a;
        }
    }

    public final void a(String key, Function1<? super Hook, Unit> hookInitializer) {
        Intrinsics3.checkNotNullParameter(key, "key");
        Intrinsics3.checkNotNullParameter(hookInitializer, "hookInitializer");
        Map<String, Hook> map = this.hooks;
        Hook hook = new Hook();
        hookInitializer.invoke(hook);
        map.put(key, hook);
    }

    public final void b(String key, Function1<? super View, Unit> onClick) {
        Intrinsics3.checkNotNullParameter(key, "key");
        Intrinsics3.checkNotNullParameter(onClick, "onClick");
        a(key, new a(onClick));
    }
}
