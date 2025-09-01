package com.discord.utilities.collections;

import androidx.exifinterface.media.ExifInterface;
import kotlin.Metadata;

/* compiled from: ListenerCollection.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0003\bf\u0018\u0000*\u0004\b\u0000\u0010\u00012\u00020\u0002J\u0017\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00028\u0000H&¢\u0006\u0004\b\u0005\u0010\u0006J\u0017\u0010\b\u001a\u00020\u00072\u0006\u0010\u0003\u001a\u00028\u0000H&¢\u0006\u0004\b\b\u0010\t¨\u0006\n"}, d2 = {"Lcom/discord/utilities/collections/ListenerCollection;", ExifInterface.GPS_DIRECTION_TRUE, "", "listener", "", "add", "(Ljava/lang/Object;)V", "", "remove", "(Ljava/lang/Object;)Z", "utils_release"}, k = 1, mv = {1, 4, 2})
/* loaded from: classes2.dex */
public interface ListenerCollection<T> {
    void add(T listener);

    boolean remove(T listener);
}
