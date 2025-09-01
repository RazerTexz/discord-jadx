package com.discord.utilities.textprocessing;

import android.content.Context;
import android.content.res.Resources;
import android.text.style.CharacterStyle;
import android.text.style.ParagraphStyle;
import android.text.style.StyleSpan;
import android.text.style.TextAppearanceSpan;
import com.discord.R;
import com.discord.utilities.color.ColorCompat;
import com.discord.utilities.spans.VerticalPaddingSpan;
import d0.t.CollectionsJVM;
import d0.z.d.Intrinsics3;
import d0.z.d.Lambda;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;

/* compiled from: ChangelogSpans.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000<\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0016\u0010\u0017J!\u0010\u0007\u001a\u000e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u00060\u00042\u0006\u0010\u0003\u001a\u00020\u0002¢\u0006\u0004\b\u0007\u0010\bJ!\u0010\t\u001a\u000e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u00060\u00042\u0006\u0010\u0003\u001a\u00020\u0002¢\u0006\u0004\b\t\u0010\bJ!\u0010\r\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\f0\u000b0\n2\u0006\u0010\u0003\u001a\u00020\u0002¢\u0006\u0004\b\r\u0010\u000eJ!\u0010\u000f\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\f0\u000b0\n2\u0006\u0010\u0003\u001a\u00020\u0002¢\u0006\u0004\b\u000f\u0010\u000eJ#\u0010\u0011\u001a\u0010\u0012\u0004\u0012\u00020\u0010\u0012\u0006\u0012\u0004\u0018\u00010\u00010\u00042\u0006\u0010\u0003\u001a\u00020\u0002¢\u0006\u0004\b\u0011\u0010\bJ!\u0010\u0013\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00120\u000b0\n2\u0006\u0010\u0003\u001a\u00020\u0002¢\u0006\u0004\b\u0013\u0010\u000eR\u0016\u0010\u0014\u001a\u00020\u00058\u0002@\u0002X\u0082T¢\u0006\u0006\n\u0004\b\u0014\u0010\u0015¨\u0006\u0018"}, d2 = {"Lcom/discord/utilities/textprocessing/ChangelogSpans;", "", "Landroid/content/Context;", "context", "Lkotlin/Function1;", "", "Landroid/text/style/CharacterStyle;", "createHeaderStyleSpanProvider", "(Landroid/content/Context;)Lkotlin/jvm/functions/Function1;", "createSpecialHeaderStyleSpanProvider", "Lkotlin/Function0;", "", "Lcom/discord/utilities/spans/VerticalPaddingSpan;", "createHeaderPaddingSpansProvider", "(Landroid/content/Context;)Lkotlin/jvm/functions/Function0;", "createChangelogSpecialHeaderPaddingSpansProvider", "", "createHeaderClassSpanProvider", "Landroid/text/style/ParagraphStyle;", "createMarkdownBulletSpansProvider", "MARKDOWN_BULLET_RADIUS", "I", "<init>", "()V", "app_productionGoogleRelease"}, k = 1, mv = {1, 4, 2})
/* loaded from: classes2.dex */
public final class ChangelogSpans {
    public static final ChangelogSpans INSTANCE = new ChangelogSpans();
    private static final int MARKDOWN_BULLET_RADIUS = 8;

    /* compiled from: ChangelogSpans.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\f\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0003\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00010\u0000H\n¢\u0006\u0004\b\u0002\u0010\u0003"}, d2 = {"", "Lcom/discord/utilities/spans/VerticalPaddingSpan;", "invoke", "()Ljava/util/List;", "<anonymous>"}, k = 3, mv = {1, 4, 2})
    /* renamed from: com.discord.utilities.textprocessing.ChangelogSpans$createChangelogSpecialHeaderPaddingSpansProvider$1, reason: invalid class name */
    public static final class AnonymousClass1 extends Lambda implements Function0<List<? extends VerticalPaddingSpan>> {
        public final /* synthetic */ int $headerBottomPx;
        public final /* synthetic */ int $headerTopPx;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public AnonymousClass1(int i, int i2) {
            super(0);
            this.$headerTopPx = i;
            this.$headerBottomPx = i2;
        }

        @Override // kotlin.jvm.functions.Function0
        public /* bridge */ /* synthetic */ List<? extends VerticalPaddingSpan> invoke() {
            return invoke2();
        }

        @Override // kotlin.jvm.functions.Function0
        /* renamed from: invoke, reason: avoid collision after fix types in other method */
        public final List<? extends VerticalPaddingSpan> invoke2() {
            return CollectionsJVM.listOf(new VerticalPaddingSpan(this.$headerTopPx, this.$headerBottomPx));
        }
    }

    /* compiled from: ChangelogSpans.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u000e\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0003\u0010\u0005\u001a\u0004\u0018\u00010\u00022\u0006\u0010\u0001\u001a\u00020\u0000H\n¢\u0006\u0004\b\u0003\u0010\u0004"}, d2 = {"", "className", "", "invoke", "(Ljava/lang/String;)Ljava/lang/Object;", "<anonymous>"}, k = 3, mv = {1, 4, 2})
    /* renamed from: com.discord.utilities.textprocessing.ChangelogSpans$createHeaderClassSpanProvider$1, reason: invalid class name */
    public static final class AnonymousClass1 extends Lambda implements Function1<String, Object> {
        public final /* synthetic */ Context $context;
        public final /* synthetic */ int $marginTopPx;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public AnonymousClass1(Context context, int i) {
            super(1);
            this.$context = context;
            this.$marginTopPx = i;
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Object invoke(String str) {
            return invoke2(str);
        }

        /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
        /* renamed from: invoke, reason: avoid collision after fix types in other method */
        public final Object invoke2(String str) {
            Intrinsics3.checkNotNullParameter(str, "className");
            switch (str.hashCode()) {
                case -1269237627:
                    if (str.equals("changelogSpecial")) {
                        return new TextAppearanceSpan(this.$context, 2131952041);
                    }
                    return null;
                case -1044792121:
                    if (str.equals("marginTop")) {
                        return new VerticalPaddingSpan(0, this.$marginTopPx);
                    }
                    return null;
                case -1001078227:
                    if (str.equals("progress")) {
                        return new TextAppearanceSpan(this.$context, 2131952039);
                    }
                    return null;
                case -419685396:
                    if (str.equals("improved")) {
                        return new TextAppearanceSpan(this.$context, 2131952038);
                    }
                    return null;
                case 92659968:
                    if (str.equals("added")) {
                        return new TextAppearanceSpan(this.$context, 2131952036);
                    }
                    return null;
                case 97445748:
                    if (str.equals("fixed")) {
                        return new TextAppearanceSpan(this.$context, 2131952037);
                    }
                    return null;
                default:
                    return null;
            }
        }
    }

    /* compiled from: ChangelogSpans.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\f\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0003\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00010\u0000H\n¢\u0006\u0004\b\u0002\u0010\u0003"}, d2 = {"", "Lcom/discord/utilities/spans/VerticalPaddingSpan;", "invoke", "()Ljava/util/List;", "<anonymous>"}, k = 3, mv = {1, 4, 2})
    /* renamed from: com.discord.utilities.textprocessing.ChangelogSpans$createHeaderPaddingSpansProvider$1, reason: invalid class name */
    public static final class AnonymousClass1 extends Lambda implements Function0<List<? extends VerticalPaddingSpan>> {
        public final /* synthetic */ int $headerBottomPx;
        public final /* synthetic */ int $headerTopPx;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public AnonymousClass1(int i, int i2) {
            super(0);
            this.$headerTopPx = i;
            this.$headerBottomPx = i2;
        }

        @Override // kotlin.jvm.functions.Function0
        public /* bridge */ /* synthetic */ List<? extends VerticalPaddingSpan> invoke() {
            return invoke2();
        }

        @Override // kotlin.jvm.functions.Function0
        /* renamed from: invoke, reason: avoid collision after fix types in other method */
        public final List<? extends VerticalPaddingSpan> invoke2() {
            return CollectionsJVM.listOf(new VerticalPaddingSpan(this.$headerTopPx, this.$headerBottomPx));
        }
    }

    /* compiled from: ChangelogSpans.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u000e\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\u0010\u0005\u001a\u00020\u00022\u0006\u0010\u0001\u001a\u00020\u0000H\n¢\u0006\u0004\b\u0003\u0010\u0004"}, d2 = {"", "header", "Landroid/text/style/CharacterStyle;", "invoke", "(I)Landroid/text/style/CharacterStyle;", "<anonymous>"}, k = 3, mv = {1, 4, 2})
    /* renamed from: com.discord.utilities.textprocessing.ChangelogSpans$createHeaderStyleSpanProvider$1, reason: invalid class name */
    public static final class AnonymousClass1 extends Lambda implements Function1<Integer, CharacterStyle> {
        public final /* synthetic */ Context $context;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public AnonymousClass1(Context context) {
            super(1);
            this.$context = context;
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ CharacterStyle invoke(Integer num) {
            return invoke(num.intValue());
        }

        public final CharacterStyle invoke(int i) {
            return i != 1 ? i != 4 ? new StyleSpan(3) : new TextAppearanceSpan(this.$context, 2131952040) : new TextAppearanceSpan(this.$context, 2131952035);
        }
    }

    /* compiled from: ChangelogSpans.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u000e\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\u0010\u0005\u001a\u00020\u00022\u0006\u0010\u0001\u001a\u00020\u0000H\n¢\u0006\u0004\b\u0003\u0010\u0004"}, d2 = {"", "header", "Landroid/text/style/CharacterStyle;", "invoke", "(I)Landroid/text/style/CharacterStyle;", "<anonymous>"}, k = 3, mv = {1, 4, 2})
    /* renamed from: com.discord.utilities.textprocessing.ChangelogSpans$createSpecialHeaderStyleSpanProvider$1, reason: invalid class name */
    public static final class AnonymousClass1 extends Lambda implements Function1<Integer, CharacterStyle> {
        public final /* synthetic */ Context $context;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public AnonymousClass1(Context context) {
            super(1);
            this.$context = context;
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ CharacterStyle invoke(Integer num) {
            return invoke(num.intValue());
        }

        public final CharacterStyle invoke(int i) {
            return i != 1 ? i != 4 ? new StyleSpan(3) : new TextAppearanceSpan(this.$context, 2131952040) : new TextAppearanceSpan(this.$context, 2131952041);
        }
    }

    private ChangelogSpans() {
    }

    public final Function0<List<VerticalPaddingSpan>> createChangelogSpecialHeaderPaddingSpansProvider(Context context) {
        Intrinsics3.checkNotNullParameter(context, "context");
        return new AnonymousClass1(context.getResources().getDimensionPixelSize(R.dimen.markdown_header_1_changelog_special_top_padding), context.getResources().getDimensionPixelSize(R.dimen.markdown_header_1_bottom_padding));
    }

    public final Function1<String, Object> createHeaderClassSpanProvider(Context context) {
        Intrinsics3.checkNotNullParameter(context, "context");
        return new AnonymousClass1(context, context.getResources().getDimensionPixelSize(R.dimen.markdown_header_class_marginTop));
    }

    public final Function0<List<VerticalPaddingSpan>> createHeaderPaddingSpansProvider(Context context) {
        Intrinsics3.checkNotNullParameter(context, "context");
        return new AnonymousClass1(context.getResources().getDimensionPixelSize(R.dimen.markdown_header_1_top_padding), context.getResources().getDimensionPixelSize(R.dimen.markdown_header_1_bottom_padding));
    }

    public final Function1<Integer, CharacterStyle> createHeaderStyleSpanProvider(Context context) {
        Intrinsics3.checkNotNullParameter(context, "context");
        return new AnonymousClass1(context);
    }

    public final Function0<List<ParagraphStyle>> createMarkdownBulletSpansProvider(Context context) throws Resources.NotFoundException {
        Intrinsics3.checkNotNullParameter(context, "context");
        return new ChangelogSpans2(context.getResources().getDimensionPixelSize(R.dimen.markdown_bullet_vertical_padding), context.getResources().getDimensionPixelSize(R.dimen.markdown_bullet_gap), ColorCompat.getThemedColor(context, R.attr.color_brand_500));
    }

    public final Function1<Integer, CharacterStyle> createSpecialHeaderStyleSpanProvider(Context context) {
        Intrinsics3.checkNotNullParameter(context, "context");
        return new AnonymousClass1(context);
    }
}
