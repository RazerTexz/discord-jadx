package com.discord.utilities.presence;

import android.content.Context;
import android.text.SpannableStringBuilder;
import androidx.annotation.StringRes;
import androidx.appcompat.widget.ActivityChooserModel;
import b.a.k.FormatUtils;
import com.discord.R;
import com.discord.api.activity.Activity;
import com.discord.api.activity.ActivityEmoji;
import com.discord.api.activity.ActivityParty;
import com.discord.api.activity.ActivityPlatform;
import com.discord.api.activity.ActivityType;
import com.discord.api.presence.ClientStatus;
import com.discord.api.presence.ClientStatuses;
import com.discord.models.presence.Presence;
import com.discord.utilities.platform.Platform;
import com.discord.utilities.textprocessing.node.EmojiNode;
import com.discord.utilities.view.text.SimpleDraweeSpanTextView;
import com.facebook.drawee.span.DraweeSpanStringBuilder;
import d0.t._Collections;
import d0.u.a;
import d0.z.d.Intrinsics3;
import java.util.Comparator;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;

/* compiled from: PresenceUtils.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000x\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\r\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0010\t\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\n\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\bH\u0010IJ=\u0010\u000b\u001a\u00020\n2\b\u0010\u0003\u001a\u0004\u0018\u00010\u00022\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u00062\b\b\u0002\u0010\b\u001a\u00020\u00042\b\b\u0002\u0010\t\u001a\u00020\u0004H\u0007¢\u0006\u0004\b\u000b\u0010\fJ\u001f\u0010\u0012\u001a\u00020\u00112\u0006\u0010\u000e\u001a\u00020\r2\u0006\u0010\u0010\u001a\u00020\u000fH\u0007¢\u0006\u0004\b\u0012\u0010\u0013J!\u0010\u0014\u001a\u00020\u00112\u0006\u0010\u000e\u001a\u00020\r2\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0002¢\u0006\u0004\b\u0014\u0010\u0015J#\u0010\u0017\u001a\u0004\u0018\u00010\u00112\u0006\u0010\u000e\u001a\u00020\r2\b\u0010\u0016\u001a\u0004\u0018\u00010\u000fH\u0002¢\u0006\u0004\b\u0017\u0010\u0013J5\u0010\u0018\u001a\u0004\u0018\u00010\u00112\u0006\u0010\u000e\u001a\u00020\r2\b\u0010\u0003\u001a\u0004\u0018\u00010\u00022\u0006\u0010\u0005\u001a\u00020\u00042\b\b\u0002\u0010\b\u001a\u00020\u0004H\u0002¢\u0006\u0004\b\u0018\u0010\u0019JE\u0010\u001c\u001a\u00020\u001b2\u0006\u0010\u000e\u001a\u00020\r2\b\u0010\u0003\u001a\u0004\u0018\u00010\u00022\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\t\u001a\u00020\u00042\b\b\u0002\u0010\b\u001a\u00020\u00042\b\b\u0002\u0010\u001a\u001a\u00020\u0004H\u0002¢\u0006\u0004\b\u001c\u0010\u001dJ\u001b\u0010\u001f\u001a\u0004\u0018\u00010\u000f*\b\u0012\u0004\u0012\u00020\u000f0\u001eH\u0002¢\u0006\u0004\b\u001f\u0010 J\u001b\u0010!\u001a\u0004\u0018\u00010\u000f*\b\u0012\u0004\u0012\u00020\u000f0\u001eH\u0002¢\u0006\u0004\b!\u0010 J\u0015\u0010\u0018\u001a\u00020\"*\u0004\u0018\u00010\u0002H\u0002¢\u0006\u0004\b\u0018\u0010#J\u0017\u0010$\u001a\u00020\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002¢\u0006\u0004\b$\u0010%J\u0017\u0010&\u001a\u00020\"2\u0006\u0010\u0003\u001a\u00020\u0002H\u0007¢\u0006\u0004\b&\u0010#J!\u0010)\u001a\u0004\u0018\u00010\u000f*\b\u0012\u0004\u0012\u00020\u000f0\u001e2\u0006\u0010(\u001a\u00020'¢\u0006\u0004\b)\u0010*R\u0019\u0010,\u001a\u0004\u0018\u00010\u000f*\u00020\u00028F@\u0006¢\u0006\u0006\u001a\u0004\b!\u0010+R\u0017\u00101\u001a\u00020.*\u00020-8F@\u0006¢\u0006\u0006\u001a\u0004\b/\u00100R\u0017\u00103\u001a\u00020.*\u00020-8F@\u0006¢\u0006\u0006\u001a\u0004\b2\u00100R\u0019\u00105\u001a\u0004\u0018\u00010\u000f*\u00020\u00028F@\u0006¢\u0006\u0006\u001a\u0004\b4\u0010+R\u0019\u00107\u001a\u0004\u0018\u00010\u000f*\u00020\u00028F@\u0006¢\u0006\u0006\u001a\u0004\b6\u0010+R,\u0010:\u001a\u0012\u0012\u0004\u0012\u00020\u000f08j\b\u0012\u0004\u0012\u00020\u000f`98\u0000@\u0000X\u0080\u0004¢\u0006\f\n\u0004\b:\u0010;\u001a\u0004\b<\u0010=R\u0019\u0010?\u001a\u0004\u0018\u00010\u000f*\u00020\u00028F@\u0006¢\u0006\u0006\u001a\u0004\b>\u0010+R\u0017\u0010A\u001a\u00020\u0004*\u00020@8F@\u0006¢\u0006\u0006\u001a\u0004\bA\u0010BR\u0017\u0010D\u001a\u00020.*\u00020-8F@\u0006¢\u0006\u0006\u001a\u0004\bC\u00100R\u0019\u0010E\u001a\u0004\u0018\u00010\u000f*\u00020\u00028F@\u0006¢\u0006\u0006\u001a\u0004\b\u001f\u0010+R\u001f\u0010?\u001a\u0004\u0018\u00010\u000f*\b\u0012\u0004\u0012\u00020\u000f0\u001e8F@\u0006¢\u0006\u0006\u001a\u0004\b>\u0010 R\u0019\u0010G\u001a\u0004\u0018\u00010\u000f*\u00020\u00028F@\u0006¢\u0006\u0006\u001a\u0004\bF\u0010+¨\u0006J"}, d2 = {"Lcom/discord/utilities/presence/PresenceUtils;", "", "Lcom/discord/models/presence/Presence;", "presence", "", "isStreamingApplication", "Lcom/discord/utilities/view/text/SimpleDraweeSpanTextView;", "textView", "showFallbackStatusText", "hideEmoji", "", "setPresenceText", "(Lcom/discord/models/presence/Presence;ZLcom/discord/utilities/view/text/SimpleDraweeSpanTextView;ZZ)V", "Landroid/content/Context;", "context", "Lcom/discord/api/activity/Activity;", ActivityChooserModel.ATTRIBUTE_ACTIVITY, "", "getActivityHeader", "(Landroid/content/Context;Lcom/discord/api/activity/Activity;)Ljava/lang/CharSequence;", "getApplicationStreamingString", "(Landroid/content/Context;Lcom/discord/models/presence/Presence;)Ljava/lang/CharSequence;", "activityModel", "getActivityString", "getStatusText", "(Landroid/content/Context;Lcom/discord/models/presence/Presence;ZZ)Ljava/lang/CharSequence;", "animateCustomStatusEmoji", "Lcom/facebook/drawee/span/DraweeSpanStringBuilder;", "getStatusDraweeSpanStringBuilder", "(Landroid/content/Context;Lcom/discord/models/presence/Presence;ZZZZ)Lcom/facebook/drawee/span/DraweeSpanStringBuilder;", "", "getStageChannelActivity", "(Ljava/util/List;)Lcom/discord/api/activity/Activity;", "getSpotifyListeningActivity", "", "(Lcom/discord/models/presence/Presence;)I", "shouldShowRichPresenceIcon", "(Lcom/discord/models/presence/Presence;)Z", "getStatusStringResForPresence", "Lcom/discord/api/activity/ActivityType;", "type", "getActivityByType", "(Ljava/util/List;Lcom/discord/api/activity/ActivityType;)Lcom/discord/api/activity/Activity;", "(Lcom/discord/models/presence/Presence;)Lcom/discord/api/activity/Activity;", "spotifyListeningActivity", "Lcom/discord/api/activity/ActivityParty;", "", "getMaxSize", "(Lcom/discord/api/activity/ActivityParty;)J", "maxSize", "getCurrentSize", "currentSize", "getPlayingActivity", "playingActivity", "getCustomStatusActivity", "customStatusActivity", "Ljava/util/Comparator;", "Lkotlin/Comparator;", "ACTIVITY_COMPARATOR", "Ljava/util/Comparator;", "getACTIVITY_COMPARATOR$app_productionGoogleRelease", "()Ljava/util/Comparator;", "getPrimaryActivity", "primaryActivity", "Lcom/discord/api/presence/ClientStatuses;", "isMobile", "(Lcom/discord/api/presence/ClientStatuses;)Z", "getNumOpenSlots", "numOpenSlots", "stageChannelActivity", "getStreamingActivity", "streamingActivity", "<init>", "()V", "app_productionGoogleRelease"}, k = 1, mv = {1, 4, 2})
/* loaded from: classes2.dex */
public final class PresenceUtils {
    public static final PresenceUtils INSTANCE = new PresenceUtils();
    private static final Comparator<Activity> ACTIVITY_COMPARATOR = a.compareBy(PresenceUtils2.INSTANCE, PresenceUtils3.INSTANCE, PresenceUtils4.INSTANCE);

    @Metadata(bv = {1, 0, 3}, d1 = {}, d2 = {}, k = 3, mv = {1, 4, 2})
    public final /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0;
        public static final /* synthetic */ int[] $EnumSwitchMapping$1;
        public static final /* synthetic */ int[] $EnumSwitchMapping$2;

        static {
            ActivityType.values();
            int[] iArr = new int[7];
            $EnumSwitchMapping$0 = iArr;
            ActivityType activityType = ActivityType.STREAMING;
            iArr[activityType.ordinal()] = 1;
            ActivityType activityType2 = ActivityType.LISTENING;
            iArr[activityType2.ordinal()] = 2;
            ActivityType activityType3 = ActivityType.WATCHING;
            iArr[activityType3.ordinal()] = 3;
            ActivityType activityType4 = ActivityType.PLAYING;
            iArr[activityType4.ordinal()] = 4;
            ActivityType activityType5 = ActivityType.COMPETING;
            iArr[activityType5.ordinal()] = 5;
            ActivityType.values();
            int[] iArr2 = new int[7];
            $EnumSwitchMapping$1 = iArr2;
            iArr2[activityType4.ordinal()] = 1;
            iArr2[activityType2.ordinal()] = 2;
            iArr2[activityType.ordinal()] = 3;
            iArr2[activityType3.ordinal()] = 4;
            iArr2[activityType5.ordinal()] = 5;
            ClientStatus.values();
            int[] iArr3 = new int[5];
            $EnumSwitchMapping$2 = iArr3;
            iArr3[ClientStatus.ONLINE.ordinal()] = 1;
            iArr3[ClientStatus.IDLE.ordinal()] = 2;
            iArr3[ClientStatus.DND.ordinal()] = 3;
        }
    }

    /* compiled from: PresenceUtils.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0019\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0002\b\u0004*\u0001\u0000\b\n\u0018\u00002\u00020\u0001R\u001c\u0010\u0003\u001a\u00020\u00028\u0016@\u0016X\u0096\u0004¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006R\u001c\u0010\b\u001a\u00020\u00078\u0016@\u0016X\u0096\u0004¢\u0006\f\n\u0004\b\b\u0010\t\u001a\u0004\b\b\u0010\n¨\u0006\u000b"}, d2 = {"com/discord/utilities/presence/PresenceUtils$getStatusDraweeSpanStringBuilder$1", "Lcom/discord/utilities/textprocessing/node/EmojiNode$RenderContext;", "Landroid/content/Context;", "context", "Landroid/content/Context;", "getContext", "()Landroid/content/Context;", "", "isAnimationEnabled", "Z", "()Z", "app_productionGoogleRelease"}, k = 1, mv = {1, 4, 2})
    /* renamed from: com.discord.utilities.presence.PresenceUtils$getStatusDraweeSpanStringBuilder$1, reason: invalid class name */
    public static final class AnonymousClass1 implements EmojiNode.RenderContext {
        public final /* synthetic */ boolean $animateCustomStatusEmoji;
        public final /* synthetic */ Context $context;
        private final Context context;
        private final boolean isAnimationEnabled;

        public AnonymousClass1(Context context, boolean z2) {
            this.$context = context;
            this.$animateCustomStatusEmoji = z2;
            this.context = context;
            this.isAnimationEnabled = z2;
        }

        @Override // com.discord.utilities.textprocessing.node.EmojiNode.RenderContext
        public Context getContext() {
            return this.context;
        }

        @Override // com.discord.utilities.textprocessing.node.EmojiNode.RenderContext
        /* renamed from: isAnimationEnabled, reason: from getter */
        public boolean getIsAnimationEnabled() {
            return this.isAnimationEnabled;
        }

        @Override // com.discord.utilities.textprocessing.node.EmojiNode.RenderContext
        public void onEmojiClicked(EmojiNode.EmojiIdAndType emojiIdAndType) {
            Intrinsics3.checkNotNullParameter(emojiIdAndType, "emojiIdAndType");
            EmojiNode.RenderContext.DefaultImpls.onEmojiClicked(this, emojiIdAndType);
        }
    }

    private PresenceUtils() {
    }

    public static final CharSequence getActivityHeader(Context context, Activity activity) {
        Object properName;
        Intrinsics3.checkNotNullParameter(context, "context");
        Intrinsics3.checkNotNullParameter(activity, ActivityChooserModel.ATTRIBUTE_ACTIVITY);
        int iOrdinal = activity.getType().ordinal();
        if (iOrdinal != 0) {
            return iOrdinal != 1 ? iOrdinal != 2 ? iOrdinal != 3 ? iOrdinal != 5 ? FormatUtils.h(context, R.string.user_activity_header_playing, new Object[0], null, 4) : FormatUtils.h(context, R.string.user_activity_header_competing, new Object[]{activity.getName()}, null, 4) : FormatUtils.h(context, R.string.user_activity_header_watching, new Object[]{activity.getName()}, null, 4) : FormatUtils.h(context, R.string.user_activity_header_listening, new Object[]{activity.getName()}, null, 4) : FormatUtils.h(context, R.string.user_activity_header_live_on_platform, new Object[]{activity.getName()}, null, 4);
        }
        ActivityPlatform platform = activity.getPlatform();
        if (platform != null) {
            Platform platformFrom = Platform.INSTANCE.from(platform);
            if (platform == ActivityPlatform.PS4) {
                properName = "PS4";
            } else if (platform == ActivityPlatform.PS5) {
                properName = "PS5";
            } else {
                properName = platform;
                if (platformFrom != Platform.NONE) {
                    properName = platformFrom.getProperName();
                }
            }
            if (properName != null) {
                return FormatUtils.h(context, R.string.user_activity_header_playing_on_platform, new Object[]{properName}, null, 4);
            }
        }
        return FormatUtils.h(context, R.string.user_activity_header_playing, new Object[0], null, 4);
    }

    private final CharSequence getActivityString(Context context, Activity activityModel) {
        ActivityType type = activityModel != null ? activityModel.getType() : null;
        if (type == null) {
            return null;
        }
        int iOrdinal = type.ordinal();
        if (iOrdinal == 0) {
            return FormatUtils.h(context, R.string.playing_game, new Object[]{activityModel.getName()}, null, 4);
        }
        if (iOrdinal == 1) {
            Object[] objArr = new Object[1];
            String details = activityModel.getDetails();
            if (details == null) {
                details = activityModel.getName();
            }
            objArr[0] = details;
            return FormatUtils.h(context, R.string.streaming, objArr, null, 4);
        }
        if (iOrdinal == 2) {
            return FormatUtils.h(context, R.string.listening_to, new Object[]{activityModel.getName()}, null, 4);
        }
        if (iOrdinal != 3) {
            if (iOrdinal != 5) {
                return null;
            }
            return FormatUtils.h(context, R.string.competing, new Object[]{activityModel.getName()}, null, 4);
        }
        Object[] objArr2 = new Object[1];
        String details2 = activityModel.getDetails();
        if (details2 == null) {
            details2 = activityModel.getName();
        }
        objArr2[0] = details2;
        return FormatUtils.h(context, R.string.watching, objArr2, null, 4);
    }

    private final CharSequence getApplicationStreamingString(Context context, Presence presence) {
        Activity playingActivity;
        return (presence == null || (playingActivity = getPlayingActivity(presence)) == null) ? FormatUtils.h(context, R.string.streaming_a_game, new Object[0], null, 4) : FormatUtils.h(context, R.string.streaming, new Object[]{playingActivity.getName()}, null, 4);
    }

    private final DraweeSpanStringBuilder getStatusDraweeSpanStringBuilder(Context context, Presence presence, boolean isStreamingApplication, boolean hideEmoji, boolean showFallbackStatusText, boolean animateCustomStatusEmoji) {
        Activity customStatusActivity;
        ActivityEmoji emoji;
        DraweeSpanStringBuilder draweeSpanStringBuilder = new DraweeSpanStringBuilder();
        EmojiNode emojiNodeFrom$default = null;
        if (!hideEmoji && presence != null && (customStatusActivity = getCustomStatusActivity(presence)) != null && (emoji = customStatusActivity.getEmoji()) != null) {
            EmojiNode.Companion companion = EmojiNode.INSTANCE;
            emojiNodeFrom$default = EmojiNode.Companion.from$default(companion, 0, companion.generateEmojiIdAndType(emoji), 1, (Object) null);
        }
        if (emojiNodeFrom$default != null) {
            emojiNodeFrom$default.render((SpannableStringBuilder) draweeSpanStringBuilder, (DraweeSpanStringBuilder) new AnonymousClass1(context, animateCustomStatusEmoji));
        }
        CharSequence statusText = getStatusText(context, presence, isStreamingApplication, showFallbackStatusText);
        if (statusText != null) {
            if (emojiNodeFrom$default != null) {
                draweeSpanStringBuilder.append((char) 8194);
            }
            draweeSpanStringBuilder.append(statusText);
        }
        return draweeSpanStringBuilder;
    }

    public static /* synthetic */ DraweeSpanStringBuilder getStatusDraweeSpanStringBuilder$default(PresenceUtils presenceUtils, Context context, Presence presence, boolean z2, boolean z3, boolean z4, boolean z5, int i, Object obj) {
        return presenceUtils.getStatusDraweeSpanStringBuilder(context, presence, z2, z3, (i & 16) != 0 ? false : z4, (i & 32) != 0 ? false : z5);
    }

    private final CharSequence getStatusText(Context context, Presence presence, boolean isStreamingApplication, boolean showFallbackStatusText) {
        Activity customStatusActivity;
        String state = (presence == null || (customStatusActivity = getCustomStatusActivity(presence)) == null) ? null : customStatusActivity.getState();
        if (state != null) {
            return state;
        }
        if (isStreamingApplication) {
            return getApplicationStreamingString(context, presence);
        }
        CharSequence activityString = getActivityString(context, presence != null ? getPrimaryActivity(presence) : null);
        if (activityString != null) {
            return activityString;
        }
        if (showFallbackStatusText) {
            return FormatUtils.h(context, getStatusText(presence), new Object[0], null, 4);
        }
        return null;
    }

    public static /* synthetic */ CharSequence getStatusText$default(PresenceUtils presenceUtils, Context context, Presence presence, boolean z2, boolean z3, int i, Object obj) {
        if ((i & 8) != 0) {
            z3 = false;
        }
        return presenceUtils.getStatusText(context, presence, z2, z3);
    }

    public static final void setPresenceText(Presence presence, boolean isStreamingApplication, SimpleDraweeSpanTextView textView, boolean showFallbackStatusText, boolean hideEmoji) {
        Intrinsics3.checkNotNullParameter(textView, "textView");
        PresenceUtils presenceUtils = INSTANCE;
        Context context = textView.getContext();
        Intrinsics3.checkNotNullExpressionValue(context, "textView.context");
        DraweeSpanStringBuilder statusDraweeSpanStringBuilder$default = getStatusDraweeSpanStringBuilder$default(presenceUtils, context, presence, isStreamingApplication, hideEmoji, showFallbackStatusText, false, 32, null);
        textView.setDraweeSpanStringBuilder(statusDraweeSpanStringBuilder$default);
        textView.setVisibility(statusDraweeSpanStringBuilder$default.length() > 0 ? 0 : 8);
    }

    public static /* synthetic */ void setPresenceText$default(Presence presence, boolean z2, SimpleDraweeSpanTextView simpleDraweeSpanTextView, boolean z3, boolean z4, int i, Object obj) {
        if ((i & 8) != 0) {
            z3 = false;
        }
        if ((i & 16) != 0) {
            z4 = false;
        }
        setPresenceText(presence, z2, simpleDraweeSpanTextView, z3, z4);
    }

    public final Comparator<Activity> getACTIVITY_COMPARATOR$app_productionGoogleRelease() {
        return ACTIVITY_COMPARATOR;
    }

    public final Activity getActivityByType(List<Activity> list, ActivityType activityType) {
        Object next;
        Intrinsics3.checkNotNullParameter(list, "$this$getActivityByType");
        Intrinsics3.checkNotNullParameter(activityType, "type");
        Iterator<T> it = list.iterator();
        while (true) {
            if (!it.hasNext()) {
                next = null;
                break;
            }
            next = it.next();
            if (((Activity) next).getType() == activityType) {
                break;
            }
        }
        return (Activity) next;
    }

    public final long getCurrentSize(ActivityParty activityParty) {
        Long l;
        Intrinsics3.checkNotNullParameter(activityParty, "$this$currentSize");
        List<Long> listB = activityParty.b();
        if (listB == null || (l = (Long) _Collections.first((List) listB)) == null) {
            return 0L;
        }
        return l.longValue();
    }

    public final Activity getCustomStatusActivity(Presence presence) {
        Intrinsics3.checkNotNullParameter(presence, "$this$customStatusActivity");
        List<Activity> activities = presence.getActivities();
        if (activities != null) {
            return getActivityByType(activities, ActivityType.CUSTOM_STATUS);
        }
        return null;
    }

    public final long getMaxSize(ActivityParty activityParty) {
        Long l;
        Intrinsics3.checkNotNullParameter(activityParty, "$this$maxSize");
        List<Long> listB = activityParty.b();
        if (listB == null || (l = (Long) _Collections.last((List) listB)) == null) {
            return 0L;
        }
        return l.longValue();
    }

    public final long getNumOpenSlots(ActivityParty activityParty) {
        Intrinsics3.checkNotNullParameter(activityParty, "$this$numOpenSlots");
        return getMaxSize(activityParty) - getCurrentSize(activityParty);
    }

    public final Activity getPlayingActivity(Presence presence) {
        Intrinsics3.checkNotNullParameter(presence, "$this$playingActivity");
        List<Activity> activities = presence.getActivities();
        if (activities != null) {
            return getActivityByType(activities, ActivityType.PLAYING);
        }
        return null;
    }

    public final Activity getPrimaryActivity(Presence presence) {
        Intrinsics3.checkNotNullParameter(presence, "$this$primaryActivity");
        List<Activity> activities = presence.getActivities();
        if (activities != null) {
            return getPrimaryActivity(activities);
        }
        return null;
    }

    public final Activity getSpotifyListeningActivity(Presence presence) {
        Intrinsics3.checkNotNullParameter(presence, "$this$spotifyListeningActivity");
        List<Activity> activities = presence.getActivities();
        if (activities != null) {
            return getSpotifyListeningActivity(activities);
        }
        return null;
    }

    public final Activity getStageChannelActivity(Presence presence) {
        Intrinsics3.checkNotNullParameter(presence, "$this$stageChannelActivity");
        List<Activity> activities = presence.getActivities();
        if (activities != null) {
            return getStageChannelActivity(activities);
        }
        return null;
    }

    @StringRes
    public final int getStatusStringResForPresence(Presence presence) {
        Intrinsics3.checkNotNullParameter(presence, "presence");
        return getStatusText(presence);
    }

    public final Activity getStreamingActivity(Presence presence) {
        Intrinsics3.checkNotNullParameter(presence, "$this$streamingActivity");
        List<Activity> activities = presence.getActivities();
        if (activities != null) {
            return getActivityByType(activities, ActivityType.STREAMING);
        }
        return null;
    }

    public final boolean isMobile(ClientStatuses clientStatuses) {
        Intrinsics3.checkNotNullParameter(clientStatuses, "$this$isMobile");
        ClientStatus clientStatusB = clientStatuses.b();
        ClientStatus clientStatus = ClientStatus.ONLINE;
        return (clientStatusB != clientStatus || clientStatuses.c() == clientStatus || clientStatuses.a() == clientStatus) ? false : true;
    }

    /* JADX WARN: Removed duplicated region for block: B:22:? A[RETURN, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final boolean shouldShowRichPresenceIcon(Presence presence) {
        List<Activity> activities;
        boolean z2;
        if (presence != null && (activities = presence.getActivities()) != null) {
            if (activities.isEmpty()) {
                z2 = false;
                if (!z2) {
                    return true;
                }
            } else {
                Iterator<T> it = activities.iterator();
                while (it.hasNext()) {
                    if (ActivityUtils.isRichPresence((Activity) it.next())) {
                        z2 = true;
                        break;
                    }
                }
                z2 = false;
                if (!z2) {
                }
            }
        }
        return false;
    }

    private final Activity getSpotifyListeningActivity(List<Activity> list) {
        Object next;
        Iterator<T> it = list.iterator();
        while (true) {
            if (!it.hasNext()) {
                next = null;
                break;
            }
            next = it.next();
            if (ActivityUtils.isSpotifyActivity((Activity) next)) {
                break;
            }
        }
        return (Activity) next;
    }

    private final Activity getStageChannelActivity(List<Activity> list) {
        Object next;
        Iterator<T> it = list.iterator();
        while (true) {
            if (!it.hasNext()) {
                next = null;
                break;
            }
            next = it.next();
            if (ActivityUtils.isStageChannelActivity((Activity) next)) {
                break;
            }
        }
        return (Activity) next;
    }

    public final Activity getPrimaryActivity(List<Activity> list) {
        Object next;
        Intrinsics3.checkNotNullParameter(list, "$this$primaryActivity");
        Iterator<T> it = list.iterator();
        while (true) {
            if (!it.hasNext()) {
                next = null;
                break;
            }
            next = it.next();
            if (((Activity) next).getType() != ActivityType.CUSTOM_STATUS) {
                break;
            }
        }
        return (Activity) next;
    }

    private final int getStatusText(Presence presence) {
        ClientStatus status = presence != null ? presence.getStatus() : null;
        if (status != null) {
            int iOrdinal = status.ordinal();
            if (iOrdinal == 0) {
                return R.string.status_online;
            }
            if (iOrdinal == 1) {
                return R.string.status_idle;
            }
            if (iOrdinal == 2) {
                return R.string.status_dnd;
            }
        }
        return R.string.status_offline;
    }
}
