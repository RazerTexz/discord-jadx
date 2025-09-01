package com.discord.api.channel;

import com.discord.api.user.User;
import d0.z.d.Intrinsics3;
import d0.z.d.Lambda;
import kotlin.Metadata;
import kotlin.jvm.functions.Function1;

/* compiled from: ChannelUtils.kt */
@Metadata(bv = {1, 0, 3}, d1 = {}, d2 = {}, k = 3, mv = {1, 4, 2})
/* renamed from: com.discord.api.channel.ChannelUtils$getDisplayName$1, reason: use source file name */
/* loaded from: classes.dex */
public final class ChannelUtils2 extends Lambda implements Function1<User, CharSequence> {
    public static final ChannelUtils2 INSTANCE = new ChannelUtils2();

    public ChannelUtils2() {
        super(1);
    }

    @Override // kotlin.jvm.functions.Function1
    public CharSequence invoke(User user) {
        User user2 = user;
        Intrinsics3.checkNotNullParameter(user2, "it");
        return user2.getUsername();
    }
}
