package com.discord.utilities.textprocessing.node;

import a0.a.a.b;
import android.content.Context;
import android.graphics.drawable.ColorDrawable;
import android.text.SpannableStringBuilder;
import androidx.exifinterface.media.ExifInterface;
import b.a.t.b.a.TextNode;
import b.d.b.a.outline;
import b.f.g.a.a.Fresco;
import b.f.g.a.a.PipelineDraweeControllerBuilder;
import b.f.g.e.v;
import b.f.g.f.GenericDraweeHierarchyBuilder;
import com.discord.R;
import com.discord.api.activity.ActivityEmoji;
import com.discord.api.message.reaction.MessageReactionEmoji;
import com.discord.app.AppLog;
import com.discord.models.domain.ModelAuditLogEntry;
import com.discord.models.domain.emoji.ModelEmojiCustom;
import com.discord.models.domain.emoji.ModelEmojiUnicode;
import com.discord.stores.StoreStream;
import com.discord.utilities.color.ColorCompat;
import com.discord.utilities.dimen.DimenUtils;
import com.discord.utilities.icon.IconUtils;
import com.discord.utilities.images.MGImages;
import com.discord.utilities.logging.Logger;
import com.discord.utilities.spans.ClickableSpan;
import com.discord.utilities.textprocessing.node.EmojiNode.RenderContext;
import com.discord.utilities.textprocessing.node.SpoilerNode;
import com.discord.utilities.view.text.SimpleDraweeSpanTextView;
import com.facebook.drawee.controller.AbstractDraweeController;
import com.facebook.drawee.drawable.ScalingUtils$ScaleType;
import com.facebook.drawee.span.DraweeSpanStringBuilder;
import d0.z.d.Intrinsics3;
import java.io.Serializable;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.DefaultConstructorMarker;

/* compiled from: EmojiNode.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000P\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0007\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\n\u0018\u0000 &*\b\b\u0000\u0010\u0002*\u00020\u00012\b\u0012\u0004\u0012\u00028\u00000\u00032\u00020\u0004:\u0003&'(BM\b\u0007\u0012\u0006\u0010#\u001a\u00020\u001c\u0012\u001e\u0010\u001d\u001a\u001a\u0012\u0004\u0012\u00020\r\u0012\u0004\u0012\u00020\u0015\u0012\u0004\u0012\u00020\u001b\u0012\u0004\u0012\u00020\u001c0\u001a\u0012\u0006\u0010 \u001a\u00020\u001f\u0012\b\b\u0002\u0010\"\u001a\u00020\u0015\u0012\b\b\u0002\u0010\u0016\u001a\u00020\u0015¢\u0006\u0004\b$\u0010%J\u001f\u0010\t\u001a\u00020\b2\u0006\u0010\u0006\u001a\u00020\u00052\u0006\u0010\u0007\u001a\u00028\u0000H\u0016¢\u0006\u0004\b\t\u0010\nJ\u001a\u0010\u000e\u001a\u00020\r2\b\u0010\f\u001a\u0004\u0018\u00010\u000bH\u0096\u0002¢\u0006\u0004\b\u000e\u0010\u000fR\"\u0010\u0010\u001a\u00020\r8\u0016@\u0016X\u0096\u000e¢\u0006\u0012\n\u0004\b\u0010\u0010\u0011\u001a\u0004\b\u0010\u0010\u0012\"\u0004\b\u0013\u0010\u0014R\u0016\u0010\u0016\u001a\u00020\u00158\u0002@\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0016\u0010\u0017R\"\u0010\u0018\u001a\u00020\r8\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\u0018\u0010\u0011\u001a\u0004\b\u0018\u0010\u0012\"\u0004\b\u0019\u0010\u0014R.\u0010\u001d\u001a\u001a\u0012\u0004\u0012\u00020\r\u0012\u0004\u0012\u00020\u0015\u0012\u0004\u0012\u00020\u001b\u0012\u0004\u0012\u00020\u001c0\u001a8\u0002@\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u001d\u0010\u001eR\u0016\u0010 \u001a\u00020\u001f8\u0002@\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b \u0010!R\u0016\u0010\"\u001a\u00020\u00158\u0002@\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\"\u0010\u0017¨\u0006)"}, d2 = {"Lcom/discord/utilities/textprocessing/node/EmojiNode;", "Lcom/discord/utilities/textprocessing/node/EmojiNode$RenderContext;", ExifInterface.GPS_DIRECTION_TRUE, "Lb/a/t/b/a/a;", "Lcom/discord/utilities/textprocessing/node/Spoilerable;", "Landroid/text/SpannableStringBuilder;", "builder", "renderContext", "", "render", "(Landroid/text/SpannableStringBuilder;Lcom/discord/utilities/textprocessing/node/EmojiNode$RenderContext;)V", "", "other", "", "equals", "(Ljava/lang/Object;)Z", "isRevealed", "Z", "()Z", "setRevealed", "(Z)V", "", "height", "I", "isJumbo", "setJumbo", "Lkotlin/Function3;", "Landroid/content/Context;", "", "urlProvider", "Lkotlin/jvm/functions/Function3;", "Lcom/discord/utilities/textprocessing/node/EmojiNode$EmojiIdAndType;", "emojiIdAndType", "Lcom/discord/utilities/textprocessing/node/EmojiNode$EmojiIdAndType;", "width", "emojiName", "<init>", "(Ljava/lang/String;Lkotlin/jvm/functions/Function3;Lcom/discord/utilities/textprocessing/node/EmojiNode$EmojiIdAndType;II)V", "Companion", "EmojiIdAndType", "RenderContext", "app_productionGoogleRelease"}, k = 1, mv = {1, 4, 2})
/* loaded from: classes2.dex */
public final class EmojiNode<T extends RenderContext> extends TextNode<T> implements Spoilerable {

    /* renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    private static final int EMOJI_SIZE = DimenUtils.dpToPixels(16);
    private static final int JUMBOIFY_SCALE_FACTOR = 3;
    private final EmojiIdAndType emojiIdAndType;
    private final int height;
    private boolean isJumbo;
    private boolean isRevealed;
    private final Function3<Boolean, Integer, Context, String> urlProvider;
    private final int width;

    /* compiled from: EmojiNode.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000p\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b*\u0010+JG\u0010\u000f\u001a\b\u0012\u0004\u0012\u00028\u00010\u000e\"\b\b\u0001\u0010\u0003*\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u00062\u0006\u0010\t\u001a\u00020\b2\u0006\u0010\u000b\u001a\u00020\n2\u0006\u0010\r\u001a\u00020\fH\u0002¢\u0006\u0004\b\u000f\u0010\u0010J/\u0010\u000f\u001a\b\u0012\u0004\u0012\u00028\u00010\u000e\"\b\b\u0001\u0010\u0003*\u00020\u00022\u0006\u0010\u0012\u001a\u00020\u00112\b\b\u0002\u0010\u000b\u001a\u00020\n¢\u0006\u0004\b\u000f\u0010\u0013J/\u0010\u000f\u001a\b\u0012\u0004\u0012\u00028\u00010\u000e\"\b\b\u0001\u0010\u0003*\u00020\u00022\u0006\u0010\u0015\u001a\u00020\u00142\b\b\u0002\u0010\u000b\u001a\u00020\n¢\u0006\u0004\b\u000f\u0010\u0016J1\u0010\u000f\u001a\n\u0012\u0004\u0012\u00028\u0001\u0018\u00010\u000e\"\b\b\u0001\u0010\u0003*\u00020\u00022\b\b\u0002\u0010\u000b\u001a\u00020\n2\u0006\u0010\r\u001a\u00020\f¢\u0006\u0004\b\u000f\u0010\u0017J/\u0010\u001d\u001a\u00020\u001c*\u00020\u00182\b\u0010\u001a\u001a\u0004\u0018\u00010\u00192\u0006\u0010\u001b\u001a\u00020\b2\b\b\u0002\u0010\u000b\u001a\u00020\nH\u0007¢\u0006\u0004\b\u001d\u0010\u001eJ\u0011\u0010 \u001a\u00020\u001f*\u00020\u0011¢\u0006\u0004\b \u0010!J\u0011\u0010 \u001a\u00020\"*\u00020\u0014¢\u0006\u0004\b \u0010#J\u0011\u0010 \u001a\u00020\f*\u00020\u0019¢\u0006\u0004\b \u0010$J\u0011\u0010 \u001a\u00020\f*\u00020%¢\u0006\u0004\b \u0010&R\u0016\u0010'\u001a\u00020\n8\u0002@\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b'\u0010(R\u0016\u0010)\u001a\u00020\n8\u0002@\u0002X\u0082T¢\u0006\u0006\n\u0004\b)\u0010(¨\u0006,"}, d2 = {"Lcom/discord/utilities/textprocessing/node/EmojiNode$Companion;", "", "Lcom/discord/utilities/textprocessing/node/EmojiNode$RenderContext;", ExifInterface.GPS_DIRECTION_TRUE, "", "emojiName", "", "emojiId", "", "isAnimated", "", "sizePx", "Lcom/discord/utilities/textprocessing/node/EmojiNode$EmojiIdAndType;", "emojiIdAndType", "Lcom/discord/utilities/textprocessing/node/EmojiNode;", "from", "(Ljava/lang/String;JZILcom/discord/utilities/textprocessing/node/EmojiNode$EmojiIdAndType;)Lcom/discord/utilities/textprocessing/node/EmojiNode;", "Lcom/discord/models/domain/emoji/ModelEmojiCustom;", "customEmoji", "(Lcom/discord/models/domain/emoji/ModelEmojiCustom;I)Lcom/discord/utilities/textprocessing/node/EmojiNode;", "Lcom/discord/models/domain/emoji/ModelEmojiUnicode;", "unicodeEmoji", "(Lcom/discord/models/domain/emoji/ModelEmojiUnicode;I)Lcom/discord/utilities/textprocessing/node/EmojiNode;", "(ILcom/discord/utilities/textprocessing/node/EmojiNode$EmojiIdAndType;)Lcom/discord/utilities/textprocessing/node/EmojiNode;", "Lcom/discord/utilities/view/text/SimpleDraweeSpanTextView;", "Lcom/discord/api/message/reaction/MessageReactionEmoji;", "emoji", "isAnimationEnabled", "", "renderEmoji", "(Lcom/discord/utilities/view/text/SimpleDraweeSpanTextView;Lcom/discord/api/message/reaction/MessageReactionEmoji;ZI)V", "Lcom/discord/utilities/textprocessing/node/EmojiNode$EmojiIdAndType$Custom;", "generateEmojiIdAndType", "(Lcom/discord/models/domain/emoji/ModelEmojiCustom;)Lcom/discord/utilities/textprocessing/node/EmojiNode$EmojiIdAndType$Custom;", "Lcom/discord/utilities/textprocessing/node/EmojiNode$EmojiIdAndType$Unicode;", "(Lcom/discord/models/domain/emoji/ModelEmojiUnicode;)Lcom/discord/utilities/textprocessing/node/EmojiNode$EmojiIdAndType$Unicode;", "(Lcom/discord/api/message/reaction/MessageReactionEmoji;)Lcom/discord/utilities/textprocessing/node/EmojiNode$EmojiIdAndType;", "Lcom/discord/api/activity/ActivityEmoji;", "(Lcom/discord/api/activity/ActivityEmoji;)Lcom/discord/utilities/textprocessing/node/EmojiNode$EmojiIdAndType;", "EMOJI_SIZE", "I", "JUMBOIFY_SCALE_FACTOR", "<init>", "()V", "app_productionGoogleRelease"}, k = 1, mv = {1, 4, 2})
    public static final class Companion {
        private Companion() {
        }

        public static /* synthetic */ EmojiNode from$default(Companion companion, ModelEmojiCustom modelEmojiCustom, int i, int i2, Object obj) {
            if ((i2 & 2) != 0) {
                i = EmojiNode.access$getEMOJI_SIZE$cp();
            }
            return companion.from(modelEmojiCustom, i);
        }

        public static /* synthetic */ void renderEmoji$default(Companion companion, SimpleDraweeSpanTextView simpleDraweeSpanTextView, MessageReactionEmoji messageReactionEmoji, boolean z2, int i, int i2, Object obj) {
            if ((i2 & 4) != 0) {
                i = EmojiNode.access$getEMOJI_SIZE$cp();
            }
            companion.renderEmoji(simpleDraweeSpanTextView, messageReactionEmoji, z2, i);
        }

        public final <T extends RenderContext> EmojiNode<T> from(ModelEmojiCustom customEmoji, int sizePx) {
            Intrinsics3.checkNotNullParameter(customEmoji, "customEmoji");
            String name = customEmoji.getName();
            Intrinsics3.checkNotNullExpressionValue(name, "customEmoji.name");
            return from(name, customEmoji.getId(), customEmoji.isAnimated(), sizePx, generateEmojiIdAndType(customEmoji));
        }

        public final EmojiIdAndType.Custom generateEmojiIdAndType(ModelEmojiCustom modelEmojiCustom) {
            Intrinsics3.checkNotNullParameter(modelEmojiCustom, "$this$generateEmojiIdAndType");
            long id2 = modelEmojiCustom.getId();
            boolean zIsAnimated = modelEmojiCustom.isAnimated();
            String name = modelEmojiCustom.getName();
            Intrinsics3.checkNotNullExpressionValue(name, "this.name");
            return new EmojiIdAndType.Custom(id2, zIsAnimated, name);
        }

        public final void renderEmoji(SimpleDraweeSpanTextView simpleDraweeSpanTextView, MessageReactionEmoji messageReactionEmoji, boolean z2) {
            renderEmoji$default(this, simpleDraweeSpanTextView, messageReactionEmoji, z2, 0, 4, null);
        }

        public final void renderEmoji(SimpleDraweeSpanTextView simpleDraweeSpanTextView, MessageReactionEmoji messageReactionEmoji, boolean z2, int i) {
            String str;
            EmojiIdAndType unicode;
            String name;
            Intrinsics3.checkNotNullParameter(simpleDraweeSpanTextView, "$this$renderEmoji");
            str = "";
            if (messageReactionEmoji == null || !messageReactionEmoji.e()) {
                if (messageReactionEmoji != null && (name = messageReactionEmoji.getName()) != null) {
                    str = name;
                }
                unicode = new EmojiIdAndType.Unicode(str);
            } else {
                String id2 = messageReactionEmoji.getId();
                long j = id2 != null ? Long.parseLong(id2) : 0L;
                boolean animated = messageReactionEmoji.getAnimated();
                String name2 = messageReactionEmoji.getName();
                unicode = new EmojiIdAndType.Custom(j, animated, name2 != null ? name2 : "");
            }
            EmojiNode<T> emojiNodeFrom = messageReactionEmoji != null ? EmojiNode.INSTANCE.from(i, unicode) : null;
            DraweeSpanStringBuilder draweeSpanStringBuilder = new DraweeSpanStringBuilder();
            draweeSpanStringBuilder.append((char) 8202);
            if (emojiNodeFrom == null) {
                simpleDraweeSpanTextView.setText(messageReactionEmoji != null ? messageReactionEmoji.getName() : null);
            } else {
                emojiNodeFrom.render((SpannableStringBuilder) draweeSpanStringBuilder, (DraweeSpanStringBuilder) new EmojiNode4(simpleDraweeSpanTextView, z2));
                simpleDraweeSpanTextView.setDraweeSpanStringBuilder(draweeSpanStringBuilder);
            }
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public static /* synthetic */ EmojiNode from$default(Companion companion, ModelEmojiUnicode modelEmojiUnicode, int i, int i2, Object obj) {
            if ((i2 & 2) != 0) {
                i = EmojiNode.access$getEMOJI_SIZE$cp();
            }
            return companion.from(modelEmojiUnicode, i);
        }

        public final EmojiIdAndType.Unicode generateEmojiIdAndType(ModelEmojiUnicode modelEmojiUnicode) {
            Intrinsics3.checkNotNullParameter(modelEmojiUnicode, "$this$generateEmojiIdAndType");
            String firstName = modelEmojiUnicode.getFirstName();
            Intrinsics3.checkNotNullExpressionValue(firstName, "this.firstName");
            return new EmojiIdAndType.Unicode(firstName);
        }

        public static /* synthetic */ EmojiNode from$default(Companion companion, int i, EmojiIdAndType emojiIdAndType, int i2, Object obj) {
            if ((i2 & 1) != 0) {
                i = EmojiNode.access$getEMOJI_SIZE$cp();
            }
            return companion.from(i, emojiIdAndType);
        }

        public final EmojiIdAndType generateEmojiIdAndType(MessageReactionEmoji messageReactionEmoji) {
            EmojiIdAndType unicode;
            Intrinsics3.checkNotNullParameter(messageReactionEmoji, "$this$generateEmojiIdAndType");
            if (messageReactionEmoji.e()) {
                String id2 = messageReactionEmoji.getId();
                long j = id2 != null ? Long.parseLong(id2) : 0L;
                boolean animated = messageReactionEmoji.getAnimated();
                String name = messageReactionEmoji.getName();
                unicode = new EmojiIdAndType.Custom(j, animated, name != null ? name : "");
            } else {
                String name2 = messageReactionEmoji.getName();
                unicode = new EmojiIdAndType.Unicode(name2 != null ? name2 : "");
            }
            return unicode;
        }

        public final <T extends RenderContext> EmojiNode<T> from(ModelEmojiUnicode unicodeEmoji, int sizePx) {
            Intrinsics3.checkNotNullParameter(unicodeEmoji, "unicodeEmoji");
            String codePoints = unicodeEmoji.getCodePoints();
            String firstName = unicodeEmoji.getFirstName();
            Intrinsics3.checkNotNullExpressionValue(firstName, "unicodeEmoji.firstName");
            return new EmojiNode<>(firstName, new EmojiNode2(codePoints), generateEmojiIdAndType(unicodeEmoji), sizePx, sizePx);
        }

        public final EmojiIdAndType generateEmojiIdAndType(ActivityEmoji activityEmoji) throws NumberFormatException {
            EmojiIdAndType unicode;
            Intrinsics3.checkNotNullParameter(activityEmoji, "$this$generateEmojiIdAndType");
            if (activityEmoji.getId() != null) {
                String id2 = activityEmoji.getId();
                Intrinsics3.checkNotNull(id2);
                long j = Long.parseLong(id2);
                boolean animated = activityEmoji.getAnimated();
                String name = activityEmoji.getName();
                unicode = new EmojiIdAndType.Custom(j, animated, name != null ? name : "");
            } else {
                String name2 = activityEmoji.getName();
                unicode = new EmojiIdAndType.Unicode(name2 != null ? name2 : "");
            }
            return unicode;
        }

        public final <T extends RenderContext> EmojiNode<T> from(int sizePx, EmojiIdAndType emojiIdAndType) {
            Intrinsics3.checkNotNullParameter(emojiIdAndType, "emojiIdAndType");
            if (emojiIdAndType instanceof EmojiIdAndType.Unicode) {
                ModelEmojiUnicode modelEmojiUnicode = StoreStream.INSTANCE.getEmojis().getUnicodeEmojiSurrogateMap().get(((EmojiIdAndType.Unicode) emojiIdAndType).getName());
                if (modelEmojiUnicode != null) {
                    return EmojiNode.INSTANCE.from(modelEmojiUnicode, sizePx);
                }
                return null;
            }
            if (!(emojiIdAndType instanceof EmojiIdAndType.Custom)) {
                throw new NoWhenBranchMatchedException();
            }
            EmojiIdAndType.Custom custom = (EmojiIdAndType.Custom) emojiIdAndType;
            return from(custom.getName(), custom.getId(), custom.isAnimated(), sizePx, emojiIdAndType);
        }

        private final <T extends RenderContext> EmojiNode<T> from(String emojiName, long emojiId, boolean isAnimated, int sizePx, EmojiIdAndType emojiIdAndType) {
            return new EmojiNode<>(emojiName, new EmojiNode3(emojiId, isAnimated), emojiIdAndType, sizePx, sizePx);
        }
    }

    /* compiled from: EmojiNode.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b6\u0018\u00002\u00020\u0001:\u0002\u0004\u0005B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003\u0082\u0001\u0002\u0006\u0007¨\u0006\b"}, d2 = {"Lcom/discord/utilities/textprocessing/node/EmojiNode$EmojiIdAndType;", "Ljava/io/Serializable;", "<init>", "()V", "Custom", "Unicode", "Lcom/discord/utilities/textprocessing/node/EmojiNode$EmojiIdAndType$Custom;", "Lcom/discord/utilities/textprocessing/node/EmojiNode$EmojiIdAndType$Unicode;", "app_productionGoogleRelease"}, k = 1, mv = {1, 4, 2})
    public static abstract class EmojiIdAndType implements Serializable {

        /* compiled from: EmojiNode.kt */
        @Metadata(bv = {1, 0, 3}, d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\b\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0002\b\u000b\b\u0086\b\u0018\u00002\u00020\u0001B\u001f\u0012\u0006\u0010\u000b\u001a\u00020\u0002\u0012\u0006\u0010\f\u001a\u00020\u0005\u0012\u0006\u0010\r\u001a\u00020\b¢\u0006\u0004\b\u001d\u0010\u001eJ\u0010\u0010\u0003\u001a\u00020\u0002HÆ\u0003¢\u0006\u0004\b\u0003\u0010\u0004J\u0010\u0010\u0006\u001a\u00020\u0005HÆ\u0003¢\u0006\u0004\b\u0006\u0010\u0007J\u0010\u0010\t\u001a\u00020\bHÆ\u0003¢\u0006\u0004\b\t\u0010\nJ.\u0010\u000e\u001a\u00020\u00002\b\b\u0002\u0010\u000b\u001a\u00020\u00022\b\b\u0002\u0010\f\u001a\u00020\u00052\b\b\u0002\u0010\r\u001a\u00020\bHÆ\u0001¢\u0006\u0004\b\u000e\u0010\u000fJ\u0010\u0010\u0010\u001a\u00020\bHÖ\u0001¢\u0006\u0004\b\u0010\u0010\nJ\u0010\u0010\u0012\u001a\u00020\u0011HÖ\u0001¢\u0006\u0004\b\u0012\u0010\u0013J\u001a\u0010\u0016\u001a\u00020\u00052\b\u0010\u0015\u001a\u0004\u0018\u00010\u0014HÖ\u0003¢\u0006\u0004\b\u0016\u0010\u0017R\u0019\u0010\f\u001a\u00020\u00058\u0006@\u0006¢\u0006\f\n\u0004\b\f\u0010\u0018\u001a\u0004\b\f\u0010\u0007R\u0019\u0010\u000b\u001a\u00020\u00028\u0006@\u0006¢\u0006\f\n\u0004\b\u000b\u0010\u0019\u001a\u0004\b\u001a\u0010\u0004R\u0019\u0010\r\u001a\u00020\b8\u0006@\u0006¢\u0006\f\n\u0004\b\r\u0010\u001b\u001a\u0004\b\u001c\u0010\n¨\u0006\u001f"}, d2 = {"Lcom/discord/utilities/textprocessing/node/EmojiNode$EmojiIdAndType$Custom;", "Lcom/discord/utilities/textprocessing/node/EmojiNode$EmojiIdAndType;", "", "component1", "()J", "", "component2", "()Z", "", "component3", "()Ljava/lang/String;", ModelAuditLogEntry.CHANGE_KEY_ID, "isAnimated", ModelAuditLogEntry.CHANGE_KEY_NAME, "copy", "(JZLjava/lang/String;)Lcom/discord/utilities/textprocessing/node/EmojiNode$EmojiIdAndType$Custom;", "toString", "", "hashCode", "()I", "", "other", "equals", "(Ljava/lang/Object;)Z", "Z", "J", "getId", "Ljava/lang/String;", "getName", "<init>", "(JZLjava/lang/String;)V", "app_productionGoogleRelease"}, k = 1, mv = {1, 4, 2})
        public static final /* data */ class Custom extends EmojiIdAndType {
            private final long id;
            private final boolean isAnimated;
            private final String name;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            public Custom(long j, boolean z2, String str) {
                super(null);
                Intrinsics3.checkNotNullParameter(str, ModelAuditLogEntry.CHANGE_KEY_NAME);
                this.id = j;
                this.isAnimated = z2;
                this.name = str;
            }

            public static /* synthetic */ Custom copy$default(Custom custom, long j, boolean z2, String str, int i, Object obj) {
                if ((i & 1) != 0) {
                    j = custom.id;
                }
                if ((i & 2) != 0) {
                    z2 = custom.isAnimated;
                }
                if ((i & 4) != 0) {
                    str = custom.name;
                }
                return custom.copy(j, z2, str);
            }

            /* renamed from: component1, reason: from getter */
            public final long getId() {
                return this.id;
            }

            /* renamed from: component2, reason: from getter */
            public final boolean getIsAnimated() {
                return this.isAnimated;
            }

            /* renamed from: component3, reason: from getter */
            public final String getName() {
                return this.name;
            }

            public final Custom copy(long id2, boolean isAnimated, String name) {
                Intrinsics3.checkNotNullParameter(name, ModelAuditLogEntry.CHANGE_KEY_NAME);
                return new Custom(id2, isAnimated, name);
            }

            public boolean equals(Object other) {
                if (this == other) {
                    return true;
                }
                if (!(other instanceof Custom)) {
                    return false;
                }
                Custom custom = (Custom) other;
                return this.id == custom.id && this.isAnimated == custom.isAnimated && Intrinsics3.areEqual(this.name, custom.name);
            }

            public final long getId() {
                return this.id;
            }

            public final String getName() {
                return this.name;
            }

            /* JADX WARN: Multi-variable type inference failed */
            public int hashCode() {
                int iA = b.a(this.id) * 31;
                boolean z2 = this.isAnimated;
                int i = z2;
                if (z2 != 0) {
                    i = 1;
                }
                int i2 = (iA + i) * 31;
                String str = this.name;
                return i2 + (str != null ? str.hashCode() : 0);
            }

            public final boolean isAnimated() {
                return this.isAnimated;
            }

            public String toString() {
                StringBuilder sbU = outline.U("Custom(id=");
                sbU.append(this.id);
                sbU.append(", isAnimated=");
                sbU.append(this.isAnimated);
                sbU.append(", name=");
                return outline.J(sbU, this.name, ")");
            }
        }

        /* compiled from: EmojiNode.kt */
        @Metadata(bv = {1, 0, 3}, d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0006\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0007\b\u0086\b\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0005\u001a\u00020\u0002¢\u0006\u0004\b\u0013\u0010\u0014J\u0010\u0010\u0003\u001a\u00020\u0002HÆ\u0003¢\u0006\u0004\b\u0003\u0010\u0004J\u001a\u0010\u0006\u001a\u00020\u00002\b\b\u0002\u0010\u0005\u001a\u00020\u0002HÆ\u0001¢\u0006\u0004\b\u0006\u0010\u0007J\u0010\u0010\b\u001a\u00020\u0002HÖ\u0001¢\u0006\u0004\b\b\u0010\u0004J\u0010\u0010\n\u001a\u00020\tHÖ\u0001¢\u0006\u0004\b\n\u0010\u000bJ\u001a\u0010\u000f\u001a\u00020\u000e2\b\u0010\r\u001a\u0004\u0018\u00010\fHÖ\u0003¢\u0006\u0004\b\u000f\u0010\u0010R\u0019\u0010\u0005\u001a\u00020\u00028\u0006@\u0006¢\u0006\f\n\u0004\b\u0005\u0010\u0011\u001a\u0004\b\u0012\u0010\u0004¨\u0006\u0015"}, d2 = {"Lcom/discord/utilities/textprocessing/node/EmojiNode$EmojiIdAndType$Unicode;", "Lcom/discord/utilities/textprocessing/node/EmojiNode$EmojiIdAndType;", "", "component1", "()Ljava/lang/String;", ModelAuditLogEntry.CHANGE_KEY_NAME, "copy", "(Ljava/lang/String;)Lcom/discord/utilities/textprocessing/node/EmojiNode$EmojiIdAndType$Unicode;", "toString", "", "hashCode", "()I", "", "other", "", "equals", "(Ljava/lang/Object;)Z", "Ljava/lang/String;", "getName", "<init>", "(Ljava/lang/String;)V", "app_productionGoogleRelease"}, k = 1, mv = {1, 4, 2})
        public static final /* data */ class Unicode extends EmojiIdAndType {
            private final String name;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            public Unicode(String str) {
                super(null);
                Intrinsics3.checkNotNullParameter(str, ModelAuditLogEntry.CHANGE_KEY_NAME);
                this.name = str;
            }

            public static /* synthetic */ Unicode copy$default(Unicode unicode, String str, int i, Object obj) {
                if ((i & 1) != 0) {
                    str = unicode.name;
                }
                return unicode.copy(str);
            }

            /* renamed from: component1, reason: from getter */
            public final String getName() {
                return this.name;
            }

            public final Unicode copy(String name) {
                Intrinsics3.checkNotNullParameter(name, ModelAuditLogEntry.CHANGE_KEY_NAME);
                return new Unicode(name);
            }

            public boolean equals(Object other) {
                if (this != other) {
                    return (other instanceof Unicode) && Intrinsics3.areEqual(this.name, ((Unicode) other).name);
                }
                return true;
            }

            public final String getName() {
                return this.name;
            }

            public int hashCode() {
                String str = this.name;
                if (str != null) {
                    return str.hashCode();
                }
                return 0;
            }

            public String toString() {
                return outline.J(outline.U("Unicode(name="), this.name, ")");
            }
        }

        private EmojiIdAndType() {
        }

        public /* synthetic */ EmojiIdAndType(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    /* compiled from: EmojiNode.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\bf\u0018\u00002\u00020\u0001J\u0017\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\u0005\u0010\u0006R\u0016\u0010\b\u001a\u00020\u00078&@&X¦\u0004¢\u0006\u0006\u001a\u0004\b\b\u0010\tR\u0016\u0010\r\u001a\u00020\n8&@&X¦\u0004¢\u0006\u0006\u001a\u0004\b\u000b\u0010\f¨\u0006\u000e"}, d2 = {"Lcom/discord/utilities/textprocessing/node/EmojiNode$RenderContext;", "", "Lcom/discord/utilities/textprocessing/node/EmojiNode$EmojiIdAndType;", "emojiIdAndType", "", "onEmojiClicked", "(Lcom/discord/utilities/textprocessing/node/EmojiNode$EmojiIdAndType;)V", "", "isAnimationEnabled", "()Z", "Landroid/content/Context;", "getContext", "()Landroid/content/Context;", "context", "app_productionGoogleRelease"}, k = 1, mv = {1, 4, 2})
    public interface RenderContext {

        /* compiled from: EmojiNode.kt */
        @Metadata(bv = {1, 0, 3}, d1 = {}, d2 = {}, k = 3, mv = {1, 4, 2})
        public static final class DefaultImpls {
            public static void onEmojiClicked(RenderContext renderContext, EmojiIdAndType emojiIdAndType) {
                Intrinsics3.checkNotNullParameter(emojiIdAndType, "emojiIdAndType");
            }
        }

        Context getContext();

        /* renamed from: isAnimationEnabled */
        boolean getIsAnimationEnabled();

        void onEmojiClicked(EmojiIdAndType emojiIdAndType);
    }

    public EmojiNode(String str, Function3<? super Boolean, ? super Integer, ? super Context, String> function3, EmojiIdAndType emojiIdAndType) {
        this(str, function3, emojiIdAndType, 0, 0, 24, null);
    }

    public EmojiNode(String str, Function3<? super Boolean, ? super Integer, ? super Context, String> function3, EmojiIdAndType emojiIdAndType, int i) {
        this(str, function3, emojiIdAndType, i, 0, 16, null);
    }

    public /* synthetic */ EmojiNode(String str, Function3 function3, EmojiIdAndType emojiIdAndType, int i, int i2, int i3, DefaultConstructorMarker defaultConstructorMarker) {
        this(str, function3, emojiIdAndType, (i3 & 8) != 0 ? EMOJI_SIZE : i, (i3 & 16) != 0 ? EMOJI_SIZE : i2);
    }

    public static final /* synthetic */ int access$getEMOJI_SIZE$cp() {
        return EMOJI_SIZE;
    }

    public static final /* synthetic */ EmojiIdAndType access$getEmojiIdAndType$p(EmojiNode emojiNode) {
        return emojiNode.emojiIdAndType;
    }

    public static final void renderEmoji(SimpleDraweeSpanTextView simpleDraweeSpanTextView, MessageReactionEmoji messageReactionEmoji, boolean z2) {
        Companion.renderEmoji$default(INSTANCE, simpleDraweeSpanTextView, messageReactionEmoji, z2, 0, 4, null);
    }

    public static final void renderEmoji(SimpleDraweeSpanTextView simpleDraweeSpanTextView, MessageReactionEmoji messageReactionEmoji, boolean z2, int i) {
        INSTANCE.renderEmoji(simpleDraweeSpanTextView, messageReactionEmoji, z2, i);
    }

    public boolean equals(Object other) {
        if (other instanceof EmojiNode) {
            EmojiNode emojiNode = (EmojiNode) other;
            if (Intrinsics3.areEqual(emojiNode.getContent(), getContent()) && emojiNode.width == this.width && emojiNode.height == this.height && emojiNode.isJumbo == this.isJumbo) {
                return true;
            }
        }
        return false;
    }

    /* renamed from: isJumbo, reason: from getter */
    public final boolean getIsJumbo() {
        return this.isJumbo;
    }

    @Override // com.discord.utilities.textprocessing.node.Spoilerable
    /* renamed from: isRevealed, reason: from getter */
    public boolean getIsRevealed() {
        return this.isRevealed;
    }

    @Override // b.a.t.b.a.TextNode, com.discord.simpleast.core.node.Node
    public /* bridge */ /* synthetic */ void render(SpannableStringBuilder spannableStringBuilder, Object obj) {
        render(spannableStringBuilder, (SpannableStringBuilder) obj);
    }

    public final void setJumbo(boolean z2) {
        this.isJumbo = z2;
    }

    @Override // com.discord.utilities.textprocessing.node.Spoilerable
    public void setRevealed(boolean z2) {
        this.isRevealed = z2;
    }

    /* JADX WARN: Type inference failed for: r1v9, types: [REQUEST, com.facebook.imagepipeline.request.ImageRequest] */
    public void render(SpannableStringBuilder builder, T renderContext) {
        Intrinsics3.checkNotNullParameter(builder, "builder");
        Intrinsics3.checkNotNullParameter(renderContext, "renderContext");
        Context context = renderContext.getContext();
        int length = builder.length();
        builder.append((CharSequence) getContent());
        boolean z2 = this.isJumbo;
        int i = this.width;
        if (z2) {
            i *= 3;
        }
        int i2 = i;
        int i3 = this.height;
        if (z2) {
            i3 *= 3;
        }
        int i4 = i3;
        int i5 = z2 ? 1 : 2;
        ?? A = MGImages.getImageRequest(this.urlProvider.invoke(Boolean.valueOf(renderContext.getIsAnimationEnabled()), Integer.valueOf(IconUtils.getMediaProxySize(i2)), renderContext.getContext()), 0, 0, true).a();
        PipelineDraweeControllerBuilder pipelineDraweeControllerBuilderA = Fresco.a();
        pipelineDraweeControllerBuilderA.h = A;
        pipelineDraweeControllerBuilderA.m = getIsRevealed();
        AbstractDraweeController abstractDraweeControllerA = pipelineDraweeControllerBuilderA.a();
        GenericDraweeHierarchyBuilder genericDraweeHierarchyBuilder = new GenericDraweeHierarchyBuilder(context.getResources());
        genericDraweeHierarchyBuilder.f = new ColorDrawable(0);
        ScalingUtils$ScaleType scalingUtils$ScaleType = ScalingUtils$ScaleType.a;
        genericDraweeHierarchyBuilder.n = v.l;
        if (!getIsRevealed()) {
            SpoilerNode.RenderContext renderContext2 = (SpoilerNode.RenderContext) (!(renderContext instanceof SpoilerNode.RenderContext) ? null : renderContext);
            genericDraweeHierarchyBuilder.b(new ColorDrawable(renderContext2 != null ? renderContext2.getSpoilerColorRes() : ColorCompat.getThemedColor(context, R.attr.theme_chat_spoiler_bg)));
        }
        int length2 = builder.length() - 1;
        ((DraweeSpanStringBuilder) builder).c(context, genericDraweeHierarchyBuilder.a(), abstractDraweeControllerA, length, length2, i2, i4, false, i5);
        if (getContent().length() == 0) {
            return;
        }
        ClickableSpan clickableSpan = new ClickableSpan(Integer.valueOf(ColorCompat.getThemedColor(context, R.attr.color_brand)), false, null, new EmojiNode5(this, renderContext), 4, null);
        if (length <= length2) {
            builder.setSpan(clickableSpan, length, length2 + 1, 33);
            return;
        }
        AppLog appLog = AppLog.g;
        StringBuilder sbU = outline.U("Span content: ");
        sbU.append(getContent());
        sbU.append('.');
        Logger.e$default(appLog, "Unable to render emoji tappable span.", new Exception(sbU.toString()), null, 4, null);
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    /* JADX WARN: Multi-variable type inference failed */
    public EmojiNode(String str, Function3<? super Boolean, ? super Integer, ? super Context, String> function3, EmojiIdAndType emojiIdAndType, int i, int i2) {
        super(str);
        Intrinsics3.checkNotNullParameter(str, "emojiName");
        Intrinsics3.checkNotNullParameter(function3, "urlProvider");
        Intrinsics3.checkNotNullParameter(emojiIdAndType, "emojiIdAndType");
        this.urlProvider = function3;
        this.emojiIdAndType = emojiIdAndType;
        this.width = i;
        this.height = i2;
        this.isRevealed = true;
    }
}
