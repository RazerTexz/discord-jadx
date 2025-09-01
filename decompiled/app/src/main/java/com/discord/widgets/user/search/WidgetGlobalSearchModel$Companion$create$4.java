package com.discord.widgets.user.search;

import android.annotation.SuppressLint;
import b.d.b.a.outline;
import com.discord.api.channel.Channel;
import com.discord.api.channel.ChannelUtils;
import com.discord.models.guild.Guild;
import com.discord.models.user.User;
import com.discord.utilities.search.SearchUtils;
import com.discord.widgets.user.search.WidgetGlobalSearchModel;
import d0.z.d.Intrinsics3;
import d0.z.d.Lambda;
import java.util.Locale;
import java.util.Objects;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function2;

/* compiled from: WidgetGlobalSearchModel.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\u0010\u0006\u001a\u0004\u0018\u00010\u0003*\u00020\u00002\u0006\u0010\u0002\u001a\u00020\u0001H\n¢\u0006\u0004\b\u0004\u0010\u0005"}, d2 = {"Lcom/discord/api/channel/Channel;", "", "channelFilter", "Lcom/discord/widgets/user/search/WidgetGlobalSearchModel$ItemDataPayload;", "invoke", "(Lcom/discord/api/channel/Channel;Ljava/lang/String;)Lcom/discord/widgets/user/search/WidgetGlobalSearchModel$ItemDataPayload;", "toItemChannel"}, k = 3, mv = {1, 4, 2})
/* loaded from: classes.dex */
public final class WidgetGlobalSearchModel$Companion$create$4 extends Lambda implements Function2<Channel, String, WidgetGlobalSearchModel.ItemDataPayload> {
    public final /* synthetic */ WidgetGlobalSearchModel.ChannelContext $channelContext;
    public final /* synthetic */ WidgetGlobalSearchModel.SearchContext $searchContext;
    public final /* synthetic */ WidgetGlobalSearchModel$Companion$create$2 $toItemUser$2;

    /* compiled from: WidgetGlobalSearchModel.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\b\n\u0002\u0018\u0002\n\u0002\b\u0003\u0010\u0003\u001a\u0004\u0018\u00010\u0000H\u000b¢\u0006\u0004\b\u0001\u0010\u0002"}, d2 = {"Lcom/discord/widgets/user/search/WidgetGlobalSearchModel$MatchedResult;", "invoke", "()Lcom/discord/widgets/user/search/WidgetGlobalSearchModel$MatchedResult;", "fuzzyMatch"}, k = 3, mv = {1, 4, 2})
    /* renamed from: com.discord.widgets.user.search.WidgetGlobalSearchModel$Companion$create$4$1, reason: invalid class name */
    public static final class AnonymousClass1 extends Lambda implements Function0<WidgetGlobalSearchModel.MatchedResult> {
        public final /* synthetic */ String $channelFilter;
        public final /* synthetic */ Channel $this_toItemChannel;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public AnonymousClass1(Channel channel, String str) {
            super(0);
            this.$this_toItemChannel = channel;
            this.$channelFilter = str;
        }

        @Override // kotlin.jvm.functions.Function0
        public /* bridge */ /* synthetic */ WidgetGlobalSearchModel.MatchedResult invoke() {
            return invoke();
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // kotlin.jvm.functions.Function0
        @SuppressLint({"DefaultLocale"})
        public final WidgetGlobalSearchModel.MatchedResult invoke() {
            String name;
            Guild guild = (Guild) outline.c(this.$this_toItemChannel, WidgetGlobalSearchModel$Companion$create$4.this.$channelContext.getGuilds());
            if (guild == null || (name = guild.getName()) == null) {
                name = "";
            }
            Channel channel = WidgetGlobalSearchModel$Companion$create$4.this.$channelContext.getChannels().get(Long.valueOf(this.$this_toItemChannel.getParentId()));
            String strC = channel != null ? ChannelUtils.c(channel) : "";
            SearchUtils searchUtils = SearchUtils.INSTANCE;
            String str = this.$channelFilter;
            Locale locale = Locale.ROOT;
            Intrinsics3.checkNotNullExpressionValue(locale, "Locale.ROOT");
            Objects.requireNonNull(str, "null cannot be cast to non-null type java.lang.String");
            String lowerCase = str.toLowerCase(locale);
            Intrinsics3.checkNotNullExpressionValue(lowerCase, "(this as java.lang.String).toLowerCase(locale)");
            String str2 = ChannelUtils.c(this.$this_toItemChannel) + ' ' + strC + ' ' + name;
            Intrinsics3.checkNotNullExpressionValue(locale, "Locale.ROOT");
            Objects.requireNonNull(str2, "null cannot be cast to non-null type java.lang.String");
            String lowerCase2 = str2.toLowerCase(locale);
            Intrinsics3.checkNotNullExpressionValue(lowerCase2, "(this as java.lang.String).toLowerCase(locale)");
            if (searchUtils.fuzzyMatch(lowerCase, lowerCase2)) {
                return new WidgetGlobalSearchModel.MatchedResult(ChannelUtils.c(this.$this_toItemChannel), -1, this.$channelFilter.length());
            }
            return null;
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public WidgetGlobalSearchModel$Companion$create$4(WidgetGlobalSearchModel.ChannelContext channelContext, WidgetGlobalSearchModel$Companion$create$2 widgetGlobalSearchModel$Companion$create$2, WidgetGlobalSearchModel.SearchContext searchContext) {
        super(2);
        this.$channelContext = channelContext;
        this.$toItemUser$2 = widgetGlobalSearchModel$Companion$create$2;
        this.$searchContext = searchContext;
    }

    @Override // kotlin.jvm.functions.Function2
    public /* bridge */ /* synthetic */ WidgetGlobalSearchModel.ItemDataPayload invoke(Channel channel, String str) {
        return invoke2(channel, str);
    }

    /* renamed from: invoke, reason: avoid collision after fix types in other method */
    public final WidgetGlobalSearchModel.ItemDataPayload invoke2(Channel channel, String str) {
        Intrinsics3.checkNotNullParameter(channel, "$this$toItemChannel");
        Intrinsics3.checkNotNullParameter(str, "channelFilter");
        AnonymousClass1 anonymousClass1 = new AnonymousClass1(channel, str);
        if (channel.getType() == 1) {
            User userA = ChannelUtils.a(channel);
            if (userA != null) {
                return this.$toItemUser$2.invoke2(userA, str, channel);
            }
            return null;
        }
        WidgetGlobalSearchModel.MatchedResult matchedResult = WidgetGlobalSearchModel.INSTANCE.toMatchedResult(ChannelUtils.c(channel), str);
        if (matchedResult == null) {
            matchedResult = anonymousClass1.invoke();
        }
        WidgetGlobalSearchModel.MatchedResult matchedResult2 = matchedResult;
        if (matchedResult2 == null) {
            return null;
        }
        Channel channel2 = this.$channelContext.getChannels().get(Long.valueOf(channel.getParentId()));
        Guild guild = (Guild) outline.c(channel, this.$channelContext.getGuilds());
        Integer num = (Integer) outline.d(channel, this.$searchContext.getMentionCounts());
        return new WidgetGlobalSearchModel.ItemChannel(matchedResult2, channel, channel2, guild, num != null ? num.intValue() : 0, this.$channelContext.getUnreadChannelIds().contains(Long.valueOf(channel.getId())));
    }
}
