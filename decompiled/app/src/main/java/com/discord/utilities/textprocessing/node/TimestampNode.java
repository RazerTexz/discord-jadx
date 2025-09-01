package com.discord.utilities.textprocessing.node;

import android.text.SpannableStringBuilder;
import android.text.format.DateUtils;
import android.text.style.BackgroundColorSpan;
import androidx.exifinterface.media.ExifInterface;
import com.discord.R;
import com.discord.simpleast.core.node.Node;
import com.discord.utilities.color.ColorCompat;
import com.discord.utilities.spans.ClickableSpan;
import com.discord.utilities.textprocessing.node.TimestampNode.RenderContext;
import d0.t.Collections2;
import d0.z.d.Intrinsics3;
import java.text.DateFormat;
import java.util.Date;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;

/* compiled from: TimestampNode.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\r\n\u0002\b\u0006\n\u0002\u0010\u000e\n\u0002\b\u0006\u0018\u0000*\b\b\u0000\u0010\u0002*\u00020\u00012\b\u0012\u0004\u0012\u00028\u00000\u0003:\u0001\u0016B\u0019\u0012\u0006\u0010\u0012\u001a\u00020\u0011\u0012\b\u0010\u0013\u001a\u0004\u0018\u00010\u0011¢\u0006\u0004\b\u0014\u0010\u0015J\u001f\u0010\b\u001a\u00020\u00072\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0006\u001a\u00028\u0000H\u0016¢\u0006\u0004\b\b\u0010\tR\u0019\u0010\u000b\u001a\u00020\n8\u0006@\u0006¢\u0006\f\n\u0004\b\u000b\u0010\f\u001a\u0004\b\r\u0010\u000eR\u0019\u0010\u000f\u001a\u00020\n8\u0006@\u0006¢\u0006\f\n\u0004\b\u000f\u0010\f\u001a\u0004\b\u0010\u0010\u000e¨\u0006\u0017"}, d2 = {"Lcom/discord/utilities/textprocessing/node/TimestampNode;", "Lcom/discord/utilities/textprocessing/node/TimestampNode$RenderContext;", ExifInterface.GPS_DIRECTION_TRUE, "Lcom/discord/simpleast/core/node/Node;", "Landroid/text/SpannableStringBuilder;", "builder", "renderContext", "", "render", "(Landroid/text/SpannableStringBuilder;Lcom/discord/utilities/textprocessing/node/TimestampNode$RenderContext;)V", "", "formatted", "Ljava/lang/CharSequence;", "getFormatted", "()Ljava/lang/CharSequence;", "full", "getFull", "", "timestampString", "formatString", "<init>", "(Ljava/lang/String;Ljava/lang/String;)V", "RenderContext", "app_productionGoogleRelease"}, k = 1, mv = {1, 4, 2})
/* loaded from: classes2.dex */
public final class TimestampNode<T extends RenderContext> extends Node<T> {
    private final CharSequence formatted;
    private final CharSequence full;

    /* compiled from: TimestampNode.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\r\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\bf\u0018\u00002\u00020\u0001J\u0017\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\u0005\u0010\u0006¨\u0006\u0007"}, d2 = {"Lcom/discord/utilities/textprocessing/node/TimestampNode$RenderContext;", "Lcom/discord/utilities/textprocessing/node/BasicRenderContext;", "", "full", "", "onTimestampClicked", "(Ljava/lang/CharSequence;)V", "app_productionGoogleRelease"}, k = 1, mv = {1, 4, 2})
    public interface RenderContext extends BasicRenderContext {

        /* compiled from: TimestampNode.kt */
        @Metadata(bv = {1, 0, 3}, d1 = {}, d2 = {}, k = 3, mv = {1, 4, 2})
        public static final class DefaultImpls {
            public static void onTimestampClicked(RenderContext renderContext, CharSequence charSequence) {
                Intrinsics3.checkNotNullParameter(charSequence, "full");
            }
        }

        void onTimestampClicked(CharSequence full);
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    /* JADX WARN: Removed duplicated region for block: B:38:0x00b2  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public TimestampNode(String str, String str2) {
        DateFormat dateInstance;
        CharSequence relativeTimeSpanString;
        super(null, 1, null);
        Intrinsics3.checkNotNullParameter(str, "timestampString");
        Date date = new Date(Long.parseLong(str) * 1000);
        String str3 = DateFormat.getDateTimeInstance(0, 3).format(date);
        Intrinsics3.checkNotNullExpressionValue(str3, "DateFormat.getDateTimeIn…ormat.SHORT).format(date)");
        this.full = str3;
        if (Intrinsics3.areEqual(str2, "R")) {
            relativeTimeSpanString = DateUtils.getRelativeTimeSpanString(date.getTime());
            Intrinsics3.checkNotNullExpressionValue(relativeTimeSpanString, "DateUtils.getRelativeTimeSpanString(date.time)");
        } else if (str2 != null) {
            int iHashCode = str2.hashCode();
            if (iHashCode == 68) {
                if (str2.equals("D")) {
                    dateInstance = DateFormat.getDateInstance(1);
                }
                relativeTimeSpanString = dateInstance.format(date);
                Intrinsics3.checkNotNullExpressionValue(relativeTimeSpanString, "when (formatString) {\n  …ORT)\n      }.format(date)");
            } else if (iHashCode == 70) {
                if (str2.equals("F")) {
                    dateInstance = DateFormat.getDateTimeInstance(0, 3);
                }
                relativeTimeSpanString = dateInstance.format(date);
                Intrinsics3.checkNotNullExpressionValue(relativeTimeSpanString, "when (formatString) {\n  …ORT)\n      }.format(date)");
            } else if (iHashCode == 84) {
                if (str2.equals(ExifInterface.GPS_DIRECTION_TRUE)) {
                    dateInstance = DateFormat.getTimeInstance(2);
                }
                relativeTimeSpanString = dateInstance.format(date);
                Intrinsics3.checkNotNullExpressionValue(relativeTimeSpanString, "when (formatString) {\n  …ORT)\n      }.format(date)");
            } else if (iHashCode == 100) {
                if (str2.equals("d")) {
                    dateInstance = DateFormat.getDateInstance(3);
                }
                relativeTimeSpanString = dateInstance.format(date);
                Intrinsics3.checkNotNullExpressionValue(relativeTimeSpanString, "when (formatString) {\n  …ORT)\n      }.format(date)");
            } else if (iHashCode != 102) {
                dateInstance = (iHashCode == 116 && str2.equals("t")) ? DateFormat.getTimeInstance(3) : DateFormat.getDateTimeInstance(1, 3);
                relativeTimeSpanString = dateInstance.format(date);
                Intrinsics3.checkNotNullExpressionValue(relativeTimeSpanString, "when (formatString) {\n  …ORT)\n      }.format(date)");
            } else {
                if (str2.equals("f")) {
                    dateInstance = DateFormat.getDateTimeInstance(1, 3);
                }
                relativeTimeSpanString = dateInstance.format(date);
                Intrinsics3.checkNotNullExpressionValue(relativeTimeSpanString, "when (formatString) {\n  …ORT)\n      }.format(date)");
            }
        }
        this.formatted = relativeTimeSpanString;
    }

    public final CharSequence getFormatted() {
        return this.formatted;
    }

    public final CharSequence getFull() {
        return this.full;
    }

    @Override // com.discord.simpleast.core.node.Node
    public /* bridge */ /* synthetic */ void render(SpannableStringBuilder spannableStringBuilder, Object obj) {
        render(spannableStringBuilder, (SpannableStringBuilder) obj);
    }

    public void render(SpannableStringBuilder builder, T renderContext) {
        Intrinsics3.checkNotNullParameter(builder, "builder");
        Intrinsics3.checkNotNullParameter(renderContext, "renderContext");
        List listListOf = Collections2.listOf(new ClickableSpan(null, false, null, new TimestampNode2(this, renderContext), 4, null), new BackgroundColorSpan(ColorCompat.getThemedColor(renderContext.getContext(), R.attr.colorBackgroundModifierAccent)));
        int length = builder.length();
        builder.append(this.formatted);
        Iterator it = listListOf.iterator();
        while (it.hasNext()) {
            builder.setSpan(it.next(), length, builder.length(), 33);
        }
    }
}
