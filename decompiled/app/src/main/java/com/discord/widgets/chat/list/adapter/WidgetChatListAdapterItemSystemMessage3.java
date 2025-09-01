package com.discord.widgets.chat.list.adapter;

import android.content.Context;
import android.text.style.AbsoluteSizeSpan;
import android.text.style.ForegroundColorSpan;
import android.text.style.StyleSpan;
import com.discord.R;
import com.discord.i18n.Hook;
import com.discord.i18n.RenderContext;
import com.discord.utilities.color.ColorCompat;
import com.discord.utilities.dimen.DimenUtils;
import com.discord.utilities.textprocessing.SimpleRoundedBackgroundSpan;
import d0.z.d.Intrinsics3;
import d0.z.d.Lambda;
import java.util.Locale;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;

/* compiled from: WidgetChatListAdapterItemSystemMessage.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0003\u0010\u0004\u001a\u00020\u0001*\u00020\u0000H\n¢\u0006\u0004\b\u0002\u0010\u0003"}, d2 = {"Lcom/discord/i18n/RenderContext;", "", "invoke", "(Lcom/discord/i18n/RenderContext;)V", "<anonymous>"}, k = 3, mv = {1, 4, 2})
/* renamed from: com.discord.widgets.chat.list.adapter.WidgetChatListAdapterItemSystemMessage$getSystemMessage$autoModRenderContext$1, reason: use source file name */
/* loaded from: classes2.dex */
public final class WidgetChatListAdapterItemSystemMessage3 extends Lambda implements Function1<RenderContext, Unit> {
    public final /* synthetic */ Context $context;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public WidgetChatListAdapterItemSystemMessage3(Context context) {
        super(1);
        this.$context = context;
    }

    @Override // kotlin.jvm.functions.Function1
    public /* bridge */ /* synthetic */ Unit invoke(RenderContext renderContext) {
        invoke2(renderContext);
        return Unit.a;
    }

    /* renamed from: invoke, reason: avoid collision after fix types in other method */
    public final void invoke2(RenderContext renderContext) {
        Intrinsics3.checkNotNullParameter(renderContext, "$receiver");
        renderContext.a("autoModHook", new AnonymousClass1());
        renderContext.a("systemHook", new AnonymousClass2());
    }

    /* compiled from: WidgetChatListAdapterItemSystemMessage.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0003\u0010\u0004\u001a\u00020\u0001*\u00020\u0000H\n¢\u0006\u0004\b\u0002\u0010\u0003"}, d2 = {"Lcom/discord/i18n/Hook;", "", "invoke", "(Lcom/discord/i18n/Hook;)V", "<anonymous>"}, k = 3, mv = {1, 4, 2})
    /* renamed from: com.discord.widgets.chat.list.adapter.WidgetChatListAdapterItemSystemMessage$getSystemMessage$autoModRenderContext$1$1, reason: invalid class name */
    public static final class AnonymousClass1 extends Lambda implements Function1<Hook, Unit> {
        public AnonymousClass1() {
            super(1);
        }

        /* renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2(Hook hook) {
            Intrinsics3.checkNotNullParameter(hook, "$receiver");
            hook.styles.add(new ForegroundColorSpan(ColorCompat.getColor(WidgetChatListAdapterItemSystemMessage3.this.$context, R.color.brand_new_360)));
            hook.styles.add(new StyleSpan(1));
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Unit invoke(Hook hook) {
            invoke2(hook);
            return Unit.a;
        }
    }

    /* compiled from: WidgetChatListAdapterItemSystemMessage.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0003\u0010\u0004\u001a\u00020\u0001*\u00020\u0000H\n¢\u0006\u0004\b\u0002\u0010\u0003"}, d2 = {"Lcom/discord/i18n/Hook;", "", "invoke", "(Lcom/discord/i18n/Hook;)V", "<anonymous>"}, k = 3, mv = {1, 4, 2})
    /* renamed from: com.discord.widgets.chat.list.adapter.WidgetChatListAdapterItemSystemMessage$getSystemMessage$autoModRenderContext$1$2, reason: invalid class name */
    public static final class AnonymousClass2 extends Lambda implements Function1<Hook, Unit> {

        /* compiled from: WidgetChatListAdapterItemSystemMessage.kt */
        @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\b\n\u0002\u0010\u000e\n\u0002\b\u0004\u0010\u0004\u001a\u0004\u0018\u00010\u00002\b\u0010\u0001\u001a\u0004\u0018\u00010\u0000H\n¢\u0006\u0004\b\u0002\u0010\u0003"}, d2 = {"", "s", "invoke", "(Ljava/lang/String;)Ljava/lang/String;", "<anonymous>"}, k = 3, mv = {1, 4, 2})
        /* renamed from: com.discord.widgets.chat.list.adapter.WidgetChatListAdapterItemSystemMessage$getSystemMessage$autoModRenderContext$1$2$1, reason: invalid class name */
        public static final class AnonymousClass1 extends Lambda implements Function1<String, String> {
            public static final AnonymousClass1 INSTANCE = new AnonymousClass1();

            public AnonymousClass1() {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ String invoke(String str) {
                return invoke2(str);
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final String invoke2(String str) {
                if (str == null) {
                    return null;
                }
                Locale locale = Locale.ROOT;
                Intrinsics3.checkNotNullExpressionValue(locale, "Locale.ROOT");
                String upperCase = str.toUpperCase(locale);
                Intrinsics3.checkNotNullExpressionValue(upperCase, "(this as java.lang.String).toUpperCase(locale)");
                return upperCase;
            }
        }

        public AnonymousClass2() {
            super(1);
        }

        /* renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2(Hook hook) {
            Intrinsics3.checkNotNullParameter(hook, "$receiver");
            hook.styles.add(new ForegroundColorSpan(ColorCompat.getThemedColor(WidgetChatListAdapterItemSystemMessage3.this.$context, R.attr.colorHeaderPrimary)));
            hook.styles.add(new AbsoluteSizeSpan(DimenUtils.dpToPixels(14)));
            hook.styles.add(new SimpleRoundedBackgroundSpan(8, 14, DimenUtils.dpToPixels(4), DimenUtils.dpToPixels(2), ColorCompat.getColor(WidgetChatListAdapterItemSystemMessage3.this.$context, R.color.brand_new_500), DimenUtils.dpToPixels(4), Integer.valueOf(ColorCompat.getColor(WidgetChatListAdapterItemSystemMessage3.this.$context, R.color.white)), false, AnonymousClass1.INSTANCE, -2, 128, null));
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Unit invoke(Hook hook) {
            invoke2(hook);
            return Unit.a;
        }
    }
}
