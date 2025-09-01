package com.discord.widgets.chat.input.autocomplete;

import b.d.b.a.outline;
import com.discord.api.channel.Channel;
import d0.t.CollectionsJVM;
import d0.z.d.Intrinsics3;
import java.util.List;
import kotlin.Metadata;

/* compiled from: Autocompletable.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000>\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\b\n\b\u0086\b\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u000e\u001a\u00020\u000b¢\u0006\u0004\b\u001f\u0010 J\u000f\u0010\u0003\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\u0003\u0010\u0004J\u000f\u0010\u0006\u001a\u00020\u0005H\u0016¢\u0006\u0004\b\u0006\u0010\u0007J\u0015\u0010\t\u001a\b\u0012\u0004\u0012\u00020\u00050\bH\u0016¢\u0006\u0004\b\t\u0010\nJ\u0010\u0010\f\u001a\u00020\u000bHÆ\u0003¢\u0006\u0004\b\f\u0010\rJ\u001a\u0010\u000f\u001a\u00020\u00002\b\b\u0002\u0010\u000e\u001a\u00020\u000bHÆ\u0001¢\u0006\u0004\b\u000f\u0010\u0010J\u0010\u0010\u0011\u001a\u00020\u0005HÖ\u0001¢\u0006\u0004\b\u0011\u0010\u0007J\u0010\u0010\u0013\u001a\u00020\u0012HÖ\u0001¢\u0006\u0004\b\u0013\u0010\u0014J\u001a\u0010\u0018\u001a\u00020\u00172\b\u0010\u0016\u001a\u0004\u0018\u00010\u0015HÖ\u0003¢\u0006\u0004\b\u0018\u0010\u0019R\u0019\u0010\u000e\u001a\u00020\u000b8\u0006@\u0006¢\u0006\f\n\u0004\b\u000e\u0010\u001a\u001a\u0004\b\u001b\u0010\rR\u001f\u0010\u001c\u001a\b\u0012\u0004\u0012\u00020\u00050\b8\u0006@\u0006¢\u0006\f\n\u0004\b\u001c\u0010\u001d\u001a\u0004\b\u001e\u0010\n¨\u0006!"}, d2 = {"Lcom/discord/widgets/chat/input/autocomplete/ChannelAutocompletable;", "Lcom/discord/widgets/chat/input/autocomplete/Autocompletable;", "Lcom/discord/widgets/chat/input/autocomplete/LeadingIdentifier;", "leadingIdentifier", "()Lcom/discord/widgets/chat/input/autocomplete/LeadingIdentifier;", "", "getInputReplacement", "()Ljava/lang/String;", "", "getInputTextMatchers", "()Ljava/util/List;", "Lcom/discord/api/channel/Channel;", "component1", "()Lcom/discord/api/channel/Channel;", "channel", "copy", "(Lcom/discord/api/channel/Channel;)Lcom/discord/widgets/chat/input/autocomplete/ChannelAutocompletable;", "toString", "", "hashCode", "()I", "", "other", "", "equals", "(Ljava/lang/Object;)Z", "Lcom/discord/api/channel/Channel;", "getChannel", "textMatchers", "Ljava/util/List;", "getTextMatchers", "<init>", "(Lcom/discord/api/channel/Channel;)V", "app_productionGoogleRelease"}, k = 1, mv = {1, 4, 2})
/* loaded from: classes2.dex */
public final /* data */ class ChannelAutocompletable extends Autocompletable {
    private final Channel channel;
    private final List<String> textMatchers;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ChannelAutocompletable(Channel channel) {
        super(null);
        Intrinsics3.checkNotNullParameter(channel, "channel");
        this.channel = channel;
        this.textMatchers = CollectionsJVM.listOf(leadingIdentifier().getIdentifier() + channel.getName());
    }

    public static /* synthetic */ ChannelAutocompletable copy$default(ChannelAutocompletable channelAutocompletable, Channel channel, int i, Object obj) {
        if ((i & 1) != 0) {
            channel = channelAutocompletable.channel;
        }
        return channelAutocompletable.copy(channel);
    }

    /* renamed from: component1, reason: from getter */
    public final Channel getChannel() {
        return this.channel;
    }

    public final ChannelAutocompletable copy(Channel channel) {
        Intrinsics3.checkNotNullParameter(channel, "channel");
        return new ChannelAutocompletable(channel);
    }

    public boolean equals(Object other) {
        if (this != other) {
            return (other instanceof ChannelAutocompletable) && Intrinsics3.areEqual(this.channel, ((ChannelAutocompletable) other).channel);
        }
        return true;
    }

    public final Channel getChannel() {
        return this.channel;
    }

    @Override // com.discord.widgets.chat.input.autocomplete.Autocompletable
    public String getInputReplacement() {
        StringBuilder sbU = outline.U("<#");
        sbU.append(this.channel.getId());
        sbU.append('>');
        return sbU.toString();
    }

    @Override // com.discord.widgets.chat.input.autocomplete.Autocompletable
    public List<String> getInputTextMatchers() {
        return this.textMatchers;
    }

    public final List<String> getTextMatchers() {
        return this.textMatchers;
    }

    public int hashCode() {
        Channel channel = this.channel;
        if (channel != null) {
            return channel.hashCode();
        }
        return 0;
    }

    @Override // com.discord.widgets.chat.input.autocomplete.Autocompletable
    public LeadingIdentifier leadingIdentifier() {
        return LeadingIdentifier.CHANNELS;
    }

    public String toString() {
        StringBuilder sbU = outline.U("ChannelAutocompletable(channel=");
        sbU.append(this.channel);
        sbU.append(")");
        return sbU.toString();
    }
}
