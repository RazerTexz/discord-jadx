package com.discord.widgets.guilds.join;

import android.view.View;
import android.widget.TextView;
import androidx.cardview.widget.CardView;
import com.discord.api.channel.Channel;
import com.discord.api.channel.ChannelUtils;
import com.discord.api.guild.welcome.GuildWelcomeChannel;
import com.discord.databinding.WidgetGuildWelcomeChannelBinding;
import com.discord.models.domain.emoji.ModelEmojiCustom;
import com.discord.stores.StoreStream;
import com.discord.utilities.icon.IconUtils;
import com.discord.utilities.images.MGImages;
import com.discord.widgets.guilds.join.WidgetGuildWelcomeSheetChannelAdapter3;
import com.facebook.drawee.view.SimpleDraweeView;
import d0.z.d.Intrinsics3;
import kotlin.Metadata;

/* compiled from: WidgetGuildWelcomeSheetChannelAdapter.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\b\u001a\u00020\u0007¢\u0006\u0004\b\n\u0010\u000bJ\u0017\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\u0005\u0010\u0006R\u0016\u0010\b\u001a\u00020\u00078\u0002@\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\b\u0010\t¨\u0006\f"}, d2 = {"Lcom/discord/widgets/guilds/join/ChannelViewHolder;", "Lcom/discord/widgets/guilds/join/BaseChannelViewHolder;", "Lcom/discord/widgets/guilds/join/ChannelItem;", "data", "", "bind", "(Lcom/discord/widgets/guilds/join/ChannelItem;)V", "Lcom/discord/databinding/WidgetGuildWelcomeChannelBinding;", "binding", "Lcom/discord/databinding/WidgetGuildWelcomeChannelBinding;", "<init>", "(Lcom/discord/databinding/WidgetGuildWelcomeChannelBinding;)V", "app_productionGoogleRelease"}, k = 1, mv = {1, 4, 2})
/* renamed from: com.discord.widgets.guilds.join.ChannelViewHolder, reason: use source file name */
/* loaded from: classes2.dex */
public final class WidgetGuildWelcomeSheetChannelAdapter4 extends WidgetGuildWelcomeSheetChannelAdapter2 {
    private final WidgetGuildWelcomeChannelBinding binding;

    /* compiled from: WidgetGuildWelcomeSheetChannelAdapter.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0003\u0010\u0006\u001a\u00020\u00032\u000e\u0010\u0002\u001a\n \u0001*\u0004\u0018\u00010\u00000\u0000H\n¢\u0006\u0004\b\u0004\u0010\u0005"}, d2 = {"Landroid/view/View;", "kotlin.jvm.PlatformType", "it", "", "onClick", "(Landroid/view/View;)V", "<anonymous>"}, k = 3, mv = {1, 4, 2})
    /* renamed from: com.discord.widgets.guilds.join.ChannelViewHolder$bind$1, reason: invalid class name */
    public static final class AnonymousClass1 implements View.OnClickListener {
        public final /* synthetic */ WidgetGuildWelcomeSheetChannelAdapter3 $data;

        public AnonymousClass1(WidgetGuildWelcomeSheetChannelAdapter3 widgetGuildWelcomeSheetChannelAdapter3) {
            this.$data = widgetGuildWelcomeSheetChannelAdapter3;
        }

        @Override // android.view.View.OnClickListener
        public final void onClick(View view) {
            ((WidgetGuildWelcomeSheetChannelAdapter3.ChannelData) this.$data).getGoToChannel().invoke(Long.valueOf(((WidgetGuildWelcomeSheetChannelAdapter3.ChannelData) this.$data).getWelcomeChannel().getChannelId()), Integer.valueOf(((WidgetGuildWelcomeSheetChannelAdapter3.ChannelData) this.$data).getIndex()));
            ((WidgetGuildWelcomeSheetChannelAdapter3.ChannelData) this.$data).getDismissSheet().invoke();
        }
    }

    /* JADX WARN: Illegal instructions before constructor call */
    public WidgetGuildWelcomeSheetChannelAdapter4(WidgetGuildWelcomeChannelBinding widgetGuildWelcomeChannelBinding) {
        Intrinsics3.checkNotNullParameter(widgetGuildWelcomeChannelBinding, "binding");
        CardView cardView = widgetGuildWelcomeChannelBinding.a;
        Intrinsics3.checkNotNullExpressionValue(cardView, "binding.root");
        super(cardView);
        this.binding = widgetGuildWelcomeChannelBinding;
    }

    @Override // com.discord.widgets.guilds.join.WidgetGuildWelcomeSheetChannelAdapter2
    public void bind(WidgetGuildWelcomeSheetChannelAdapter3 data) {
        Intrinsics3.checkNotNullParameter(data, "data");
        super.bind(data);
        WidgetGuildWelcomeSheetChannelAdapter3.ChannelData channelData = (WidgetGuildWelcomeSheetChannelAdapter3.ChannelData) data;
        SimpleDraweeView simpleDraweeView = this.binding.d;
        Intrinsics3.checkNotNullExpressionValue(simpleDraweeView, "binding.guildWelcomeChannelEmoji");
        int mediaProxySize = IconUtils.getMediaProxySize(simpleDraweeView.getLayoutParams().width);
        GuildWelcomeChannel welcomeChannel = channelData.getWelcomeChannel();
        Intrinsics3.checkNotNullParameter(welcomeChannel, "$this$getEmojiUri");
        Long emojiId = welcomeChannel.getEmojiId();
        String imageUri = emojiId != null ? ModelEmojiCustom.getImageUri(emojiId.longValue(), false, mediaProxySize) : null;
        TextView textView = this.binding.c;
        Intrinsics3.checkNotNullExpressionValue(textView, "binding.guildWelcomeChannelDescription");
        textView.setText(channelData.getWelcomeChannel().getDescription());
        TextView textView2 = this.binding.e;
        Intrinsics3.checkNotNullExpressionValue(textView2, "binding.guildWelcomeChannelName");
        Channel channelFindChannelById = StoreStream.INSTANCE.getChannels().findChannelById(channelData.getWelcomeChannel().getChannelId());
        textView2.setText(String.valueOf(channelFindChannelById != null ? ChannelUtils.c(channelFindChannelById) : null));
        this.binding.f2456b.setOnClickListener(new AnonymousClass1(data));
        if (imageUri != null) {
            SimpleDraweeView simpleDraweeView2 = this.binding.d;
            Intrinsics3.checkNotNullExpressionValue(simpleDraweeView2, "binding.guildWelcomeChannelEmoji");
            MGImages.setImage$default(simpleDraweeView2, imageUri, 0, 0, false, null, null, 124, null);
            SimpleDraweeView simpleDraweeView3 = this.binding.d;
            Intrinsics3.checkNotNullExpressionValue(simpleDraweeView3, "binding.guildWelcomeChannelEmoji");
            simpleDraweeView3.setVisibility(0);
            TextView textView3 = this.binding.f;
            Intrinsics3.checkNotNullExpressionValue(textView3, "binding.guildWelcomeChannelUnicodeEmoji");
            textView3.setVisibility(8);
            return;
        }
        if (channelData.getWelcomeChannel().getEmojiName() != null) {
            SimpleDraweeView simpleDraweeView4 = this.binding.d;
            Intrinsics3.checkNotNullExpressionValue(simpleDraweeView4, "binding.guildWelcomeChannelEmoji");
            simpleDraweeView4.setVisibility(8);
            TextView textView4 = this.binding.f;
            Intrinsics3.checkNotNullExpressionValue(textView4, "binding.guildWelcomeChannelUnicodeEmoji");
            textView4.setVisibility(0);
            TextView textView5 = this.binding.f;
            Intrinsics3.checkNotNullExpressionValue(textView5, "binding.guildWelcomeChannelUnicodeEmoji");
            textView5.setText(channelData.getWelcomeChannel().getEmojiName());
        }
    }
}
