package com.discord.api.thread;

import kotlin.Metadata;

/* compiled from: ThreadMemberFlags.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\b\n\u0002\b\b\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\b\u0010\tR\u0016\u0010\u0003\u001a\u00020\u00028\u0006@\u0006X\u0086T¢\u0006\u0006\n\u0004\b\u0003\u0010\u0004R\u0016\u0010\u0005\u001a\u00020\u00028\u0006@\u0006X\u0086T¢\u0006\u0006\n\u0004\b\u0005\u0010\u0004R\u0016\u0010\u0006\u001a\u00020\u00028\u0006@\u0006X\u0086T¢\u0006\u0006\n\u0004\b\u0006\u0010\u0004R\u0016\u0010\u0007\u001a\u00020\u00028\u0006@\u0006X\u0086T¢\u0006\u0006\n\u0004\b\u0007\u0010\u0004¨\u0006\n"}, d2 = {"Lcom/discord/api/thread/ThreadMemberFlags;", "", "", "NO_MESSAGES", "I", "ALL_MESSAGES", "HAS_INTERACTED", "ONLY_MENTIONS", "<init>", "()V", "discord_api"}, k = 1, mv = {1, 4, 2})
/* loaded from: classes.dex */
public final class ThreadMemberFlags {
    public static final int ALL_MESSAGES = 2;
    public static final int HAS_INTERACTED = 1;
    public static final ThreadMemberFlags INSTANCE = new ThreadMemberFlags();
    public static final int NO_MESSAGES = 8;
    public static final int ONLY_MENTIONS = 4;
}
