package com.discord.widgets.chat.input.models;

import b.d.b.a.outline;
import com.discord.widgets.chat.input.autocomplete.Autocompletable;
import d0.z.d.Intrinsics3;
import java.util.Map;
import kotlin.Metadata;
import kotlin.ranges.Ranges2;

/* compiled from: ChatInputMentionsMap.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\r\n\u0002\b\u0002\n\u0002\u0010$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\t\b\u0086\b\u0018\u00002\u00020\u0001B#\u0012\u0006\u0010\n\u001a\u00020\u0002\u0012\u0012\u0010\u000b\u001a\u000e\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u00070\u0005¢\u0006\u0004\b\u001c\u0010\u001dJ\u0010\u0010\u0003\u001a\u00020\u0002HÆ\u0003¢\u0006\u0004\b\u0003\u0010\u0004J\u001c\u0010\b\u001a\u000e\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u00070\u0005HÆ\u0003¢\u0006\u0004\b\b\u0010\tJ0\u0010\f\u001a\u00020\u00002\b\b\u0002\u0010\n\u001a\u00020\u00022\u0014\b\u0002\u0010\u000b\u001a\u000e\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u00070\u0005HÆ\u0001¢\u0006\u0004\b\f\u0010\rJ\u0010\u0010\u000f\u001a\u00020\u000eHÖ\u0001¢\u0006\u0004\b\u000f\u0010\u0010J\u0010\u0010\u0012\u001a\u00020\u0011HÖ\u0001¢\u0006\u0004\b\u0012\u0010\u0013J\u001a\u0010\u0016\u001a\u00020\u00152\b\u0010\u0014\u001a\u0004\u0018\u00010\u0001HÖ\u0003¢\u0006\u0004\b\u0016\u0010\u0017R%\u0010\u000b\u001a\u000e\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u00070\u00058\u0006@\u0006¢\u0006\f\n\u0004\b\u000b\u0010\u0018\u001a\u0004\b\u0019\u0010\tR\u0019\u0010\n\u001a\u00020\u00028\u0006@\u0006¢\u0006\f\n\u0004\b\n\u0010\u001a\u001a\u0004\b\u001b\u0010\u0004¨\u0006\u001e"}, d2 = {"Lcom/discord/widgets/chat/input/models/ChatInputMentionsMap;", "", "", "component1", "()Ljava/lang/CharSequence;", "", "Lkotlin/ranges/IntRange;", "Lcom/discord/widgets/chat/input/autocomplete/Autocompletable;", "component2", "()Ljava/util/Map;", "input", "mentions", "copy", "(Ljava/lang/CharSequence;Ljava/util/Map;)Lcom/discord/widgets/chat/input/models/ChatInputMentionsMap;", "", "toString", "()Ljava/lang/String;", "", "hashCode", "()I", "other", "", "equals", "(Ljava/lang/Object;)Z", "Ljava/util/Map;", "getMentions", "Ljava/lang/CharSequence;", "getInput", "<init>", "(Ljava/lang/CharSequence;Ljava/util/Map;)V", "app_productionGoogleRelease"}, k = 1, mv = {1, 4, 2})
/* loaded from: classes2.dex */
public final /* data */ class ChatInputMentionsMap {
    private final CharSequence input;
    private final Map<Ranges2, Autocompletable> mentions;

    /* JADX WARN: Multi-variable type inference failed */
    public ChatInputMentionsMap(CharSequence charSequence, Map<Ranges2, ? extends Autocompletable> map) {
        Intrinsics3.checkNotNullParameter(charSequence, "input");
        Intrinsics3.checkNotNullParameter(map, "mentions");
        this.input = charSequence;
        this.mentions = map;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ ChatInputMentionsMap copy$default(ChatInputMentionsMap chatInputMentionsMap, CharSequence charSequence, Map map, int i, Object obj) {
        if ((i & 1) != 0) {
            charSequence = chatInputMentionsMap.input;
        }
        if ((i & 2) != 0) {
            map = chatInputMentionsMap.mentions;
        }
        return chatInputMentionsMap.copy(charSequence, map);
    }

    /* renamed from: component1, reason: from getter */
    public final CharSequence getInput() {
        return this.input;
    }

    public final Map<Ranges2, Autocompletable> component2() {
        return this.mentions;
    }

    public final ChatInputMentionsMap copy(CharSequence input, Map<Ranges2, ? extends Autocompletable> mentions) {
        Intrinsics3.checkNotNullParameter(input, "input");
        Intrinsics3.checkNotNullParameter(mentions, "mentions");
        return new ChatInputMentionsMap(input, mentions);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof ChatInputMentionsMap)) {
            return false;
        }
        ChatInputMentionsMap chatInputMentionsMap = (ChatInputMentionsMap) other;
        return Intrinsics3.areEqual(this.input, chatInputMentionsMap.input) && Intrinsics3.areEqual(this.mentions, chatInputMentionsMap.mentions);
    }

    public final CharSequence getInput() {
        return this.input;
    }

    public final Map<Ranges2, Autocompletable> getMentions() {
        return this.mentions;
    }

    public int hashCode() {
        CharSequence charSequence = this.input;
        int iHashCode = (charSequence != null ? charSequence.hashCode() : 0) * 31;
        Map<Ranges2, Autocompletable> map = this.mentions;
        return iHashCode + (map != null ? map.hashCode() : 0);
    }

    public String toString() {
        StringBuilder sbU = outline.U("ChatInputMentionsMap(input=");
        sbU.append(this.input);
        sbU.append(", mentions=");
        return outline.M(sbU, this.mentions, ")");
    }
}
