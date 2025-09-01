package com.discord.api.message.attachment;

import d0.t.Collections2;
import java.util.List;
import kotlin.Metadata;

/* compiled from: MessageAttachment.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\f\n\u0002\u0010 \n\u0002\u0010\u000e\n\u0002\b\u0007\"\u001f\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00010\u00008\u0006@\u0006¢\u0006\f\n\u0004\b\u0002\u0010\u0003\u001a\u0004\b\u0004\u0010\u0005\"\u001f\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00010\u00008\u0006@\u0006¢\u0006\f\n\u0004\b\u0006\u0010\u0003\u001a\u0004\b\u0007\u0010\u0005¨\u0006\b"}, d2 = {"", "", "IMAGE_MIME_TYPES", "Ljava/util/List;", "a", "()Ljava/util/List;", "VIDEO_MIME_TYPES", "b", "discord_api"}, k = 2, mv = {1, 4, 2})
/* renamed from: com.discord.api.message.attachment.MessageAttachmentKt, reason: use source file name */
/* loaded from: classes.dex */
public final class MessageAttachment2 {
    private static final List<String> IMAGE_MIME_TYPES = Collections2.listOf((Object[]) new String[]{".jpeg", ".jpg", ".gif", ".png", ".bmp", ".webp"});
    private static final List<String> VIDEO_MIME_TYPES = Collections2.listOf((Object[]) new String[]{".webm", ".mov", ".mpeg", ".mpg", ".mp4"});

    public static final List<String> a() {
        return IMAGE_MIME_TYPES;
    }

    public static final List<String> b() {
        return VIDEO_MIME_TYPES;
    }
}
