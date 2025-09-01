package com.discord.utilities.rx;

import androidx.core.app.NotificationCompat;
import d0.z.d.Intrinsics3;
import kotlin.Metadata;
import kotlin.jvm.functions.Function10;
import kotlin.jvm.functions.Function11;
import kotlin.jvm.functions.Function12;
import kotlin.jvm.functions.Function13;
import kotlin.jvm.functions.Function14;
import kotlin.jvm.functions.Function15;
import kotlin.jvm.functions.Function16;
import kotlin.jvm.functions.Function17;
import kotlin.jvm.functions.Function22;
import rx.Observable;
import rx.functions.Func2;
import rx.functions.Func3;
import rx.functions.Func4;
import rx.functions.Func5;
import rx.functions.Func6;
import rx.functions.Func7;
import rx.functions.Func8;
import rx.functions.Func9;

/* compiled from: ObservableCombineLatestOverloads.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000Z\n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\u001a«\u0002\u0010\u0018\u001a\b\u0012\u0004\u0012\u00028\n0\u000b\"\u0004\b\u0000\u0010\u0000\"\u0004\b\u0001\u0010\u0001\"\u0004\b\u0002\u0010\u0002\"\u0004\b\u0003\u0010\u0003\"\u0004\b\u0004\u0010\u0004\"\u0004\b\u0005\u0010\u0005\"\u0004\b\u0006\u0010\u0006\"\u0004\b\u0007\u0010\u0007\"\u0004\b\b\u0010\b\"\u0004\b\t\u0010\t\"\u0004\b\n\u0010\n2\f\u0010\f\u001a\b\u0012\u0004\u0012\u00028\u00000\u000b2\f\u0010\r\u001a\b\u0012\u0004\u0012\u00028\u00010\u000b2\f\u0010\u000e\u001a\b\u0012\u0004\u0012\u00028\u00020\u000b2\f\u0010\u000f\u001a\b\u0012\u0004\u0012\u00028\u00030\u000b2\f\u0010\u0010\u001a\b\u0012\u0004\u0012\u00028\u00040\u000b2\f\u0010\u0011\u001a\b\u0012\u0004\u0012\u00028\u00050\u000b2\f\u0010\u0012\u001a\b\u0012\u0004\u0012\u00028\u00060\u000b2\f\u0010\u0013\u001a\b\u0012\u0004\u0012\u00028\u00070\u000b2\f\u0010\u0014\u001a\b\u0012\u0004\u0012\u00028\b0\u000b2\f\u0010\u0015\u001a\b\u0012\u0004\u0012\u00028\t0\u000b2H\u0010\u0017\u001aD\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u0001\u0012\u0004\u0012\u00028\u0002\u0012\u0004\u0012\u00028\u0003\u0012\u0004\u0012\u00028\u0004\u0012\u0004\u0012\u00028\u0005\u0012\u0004\u0012\u00028\u0006\u0012\u0004\u0012\u00028\u0007\u0012\u0004\u0012\u00028\b\u0012\u0004\u0012\u00028\t\u0012\u0004\u0012\u00028\n0\u0016¢\u0006\u0004\b\u0018\u0010\u0019\u001aÅ\u0002\u0010\u0018\u001a\b\u0012\u0004\u0012\u00028\u000b0\u000b\"\u0004\b\u0000\u0010\u0000\"\u0004\b\u0001\u0010\u0001\"\u0004\b\u0002\u0010\u0002\"\u0004\b\u0003\u0010\u0003\"\u0004\b\u0004\u0010\u0004\"\u0004\b\u0005\u0010\u0005\"\u0004\b\u0006\u0010\u0006\"\u0004\b\u0007\u0010\u0007\"\u0004\b\b\u0010\b\"\u0004\b\t\u0010\t\"\u0004\b\n\u0010\u001a\"\u0004\b\u000b\u0010\n2\f\u0010\f\u001a\b\u0012\u0004\u0012\u00028\u00000\u000b2\f\u0010\r\u001a\b\u0012\u0004\u0012\u00028\u00010\u000b2\f\u0010\u000e\u001a\b\u0012\u0004\u0012\u00028\u00020\u000b2\f\u0010\u000f\u001a\b\u0012\u0004\u0012\u00028\u00030\u000b2\f\u0010\u0010\u001a\b\u0012\u0004\u0012\u00028\u00040\u000b2\f\u0010\u0011\u001a\b\u0012\u0004\u0012\u00028\u00050\u000b2\f\u0010\u0012\u001a\b\u0012\u0004\u0012\u00028\u00060\u000b2\f\u0010\u0013\u001a\b\u0012\u0004\u0012\u00028\u00070\u000b2\f\u0010\u0014\u001a\b\u0012\u0004\u0012\u00028\b0\u000b2\f\u0010\u0015\u001a\b\u0012\u0004\u0012\u00028\t0\u000b2\f\u0010\u001b\u001a\b\u0012\u0004\u0012\u00028\n0\u000b2N\u0010\u0017\u001aJ\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u0001\u0012\u0004\u0012\u00028\u0002\u0012\u0004\u0012\u00028\u0003\u0012\u0004\u0012\u00028\u0004\u0012\u0004\u0012\u00028\u0005\u0012\u0004\u0012\u00028\u0006\u0012\u0004\u0012\u00028\u0007\u0012\u0004\u0012\u00028\b\u0012\u0004\u0012\u00028\t\u0012\u0004\u0012\u00028\n\u0012\u0004\u0012\u00028\u000b0\u001c¢\u0006\u0004\b\u0018\u0010\u001d\u001aß\u0002\u0010\u0018\u001a\b\u0012\u0004\u0012\u00028\f0\u000b\"\u0004\b\u0000\u0010\u0000\"\u0004\b\u0001\u0010\u0001\"\u0004\b\u0002\u0010\u0002\"\u0004\b\u0003\u0010\u0003\"\u0004\b\u0004\u0010\u0004\"\u0004\b\u0005\u0010\u0005\"\u0004\b\u0006\u0010\u0006\"\u0004\b\u0007\u0010\u0007\"\u0004\b\b\u0010\b\"\u0004\b\t\u0010\t\"\u0004\b\n\u0010\u001a\"\u0004\b\u000b\u0010\u001e\"\u0004\b\f\u0010\n2\f\u0010\f\u001a\b\u0012\u0004\u0012\u00028\u00000\u000b2\f\u0010\r\u001a\b\u0012\u0004\u0012\u00028\u00010\u000b2\f\u0010\u000e\u001a\b\u0012\u0004\u0012\u00028\u00020\u000b2\f\u0010\u000f\u001a\b\u0012\u0004\u0012\u00028\u00030\u000b2\f\u0010\u0010\u001a\b\u0012\u0004\u0012\u00028\u00040\u000b2\f\u0010\u0011\u001a\b\u0012\u0004\u0012\u00028\u00050\u000b2\f\u0010\u0012\u001a\b\u0012\u0004\u0012\u00028\u00060\u000b2\f\u0010\u0013\u001a\b\u0012\u0004\u0012\u00028\u00070\u000b2\f\u0010\u0014\u001a\b\u0012\u0004\u0012\u00028\b0\u000b2\f\u0010\u0015\u001a\b\u0012\u0004\u0012\u00028\t0\u000b2\f\u0010\u001b\u001a\b\u0012\u0004\u0012\u00028\n0\u000b2\f\u0010\u001f\u001a\b\u0012\u0004\u0012\u00028\u000b0\u000b2T\u0010\u0017\u001aP\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u0001\u0012\u0004\u0012\u00028\u0002\u0012\u0004\u0012\u00028\u0003\u0012\u0004\u0012\u00028\u0004\u0012\u0004\u0012\u00028\u0005\u0012\u0004\u0012\u00028\u0006\u0012\u0004\u0012\u00028\u0007\u0012\u0004\u0012\u00028\b\u0012\u0004\u0012\u00028\t\u0012\u0004\u0012\u00028\n\u0012\u0004\u0012\u00028\u000b\u0012\u0004\u0012\u00028\f0 ¢\u0006\u0004\b\u0018\u0010!\u001aù\u0002\u0010\u0018\u001a\b\u0012\u0004\u0012\u00028\r0\u000b\"\u0004\b\u0000\u0010\u0000\"\u0004\b\u0001\u0010\u0001\"\u0004\b\u0002\u0010\u0002\"\u0004\b\u0003\u0010\u0003\"\u0004\b\u0004\u0010\u0004\"\u0004\b\u0005\u0010\u0005\"\u0004\b\u0006\u0010\u0006\"\u0004\b\u0007\u0010\u0007\"\u0004\b\b\u0010\b\"\u0004\b\t\u0010\t\"\u0004\b\n\u0010\u001a\"\u0004\b\u000b\u0010\u001e\"\u0004\b\f\u0010\"\"\u0004\b\r\u0010\n2\f\u0010\f\u001a\b\u0012\u0004\u0012\u00028\u00000\u000b2\f\u0010\r\u001a\b\u0012\u0004\u0012\u00028\u00010\u000b2\f\u0010\u000e\u001a\b\u0012\u0004\u0012\u00028\u00020\u000b2\f\u0010\u000f\u001a\b\u0012\u0004\u0012\u00028\u00030\u000b2\f\u0010\u0010\u001a\b\u0012\u0004\u0012\u00028\u00040\u000b2\f\u0010\u0011\u001a\b\u0012\u0004\u0012\u00028\u00050\u000b2\f\u0010\u0012\u001a\b\u0012\u0004\u0012\u00028\u00060\u000b2\f\u0010\u0013\u001a\b\u0012\u0004\u0012\u00028\u00070\u000b2\f\u0010\u0014\u001a\b\u0012\u0004\u0012\u00028\b0\u000b2\f\u0010\u0015\u001a\b\u0012\u0004\u0012\u00028\t0\u000b2\f\u0010\u001b\u001a\b\u0012\u0004\u0012\u00028\n0\u000b2\f\u0010\u001f\u001a\b\u0012\u0004\u0012\u00028\u000b0\u000b2\f\u0010#\u001a\b\u0012\u0004\u0012\u00028\f0\u000b2Z\u0010\u0017\u001aV\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u0001\u0012\u0004\u0012\u00028\u0002\u0012\u0004\u0012\u00028\u0003\u0012\u0004\u0012\u00028\u0004\u0012\u0004\u0012\u00028\u0005\u0012\u0004\u0012\u00028\u0006\u0012\u0004\u0012\u00028\u0007\u0012\u0004\u0012\u00028\b\u0012\u0004\u0012\u00028\t\u0012\u0004\u0012\u00028\n\u0012\u0004\u0012\u00028\u000b\u0012\u0004\u0012\u00028\f\u0012\u0004\u0012\u00028\r0$¢\u0006\u0004\b\u0018\u0010%\u001a\u0093\u0003\u0010\u0018\u001a\b\u0012\u0004\u0012\u00028\u000e0\u000b\"\u0004\b\u0000\u0010\u0000\"\u0004\b\u0001\u0010\u0001\"\u0004\b\u0002\u0010\u0002\"\u0004\b\u0003\u0010\u0003\"\u0004\b\u0004\u0010\u0004\"\u0004\b\u0005\u0010\u0005\"\u0004\b\u0006\u0010\u0006\"\u0004\b\u0007\u0010\u0007\"\u0004\b\b\u0010\b\"\u0004\b\t\u0010\t\"\u0004\b\n\u0010\u001a\"\u0004\b\u000b\u0010\u001e\"\u0004\b\f\u0010\"\"\u0004\b\r\u0010&\"\u0004\b\u000e\u0010\n2\f\u0010\f\u001a\b\u0012\u0004\u0012\u00028\u00000\u000b2\f\u0010\r\u001a\b\u0012\u0004\u0012\u00028\u00010\u000b2\f\u0010\u000e\u001a\b\u0012\u0004\u0012\u00028\u00020\u000b2\f\u0010\u000f\u001a\b\u0012\u0004\u0012\u00028\u00030\u000b2\f\u0010\u0010\u001a\b\u0012\u0004\u0012\u00028\u00040\u000b2\f\u0010\u0011\u001a\b\u0012\u0004\u0012\u00028\u00050\u000b2\f\u0010\u0012\u001a\b\u0012\u0004\u0012\u00028\u00060\u000b2\f\u0010\u0013\u001a\b\u0012\u0004\u0012\u00028\u00070\u000b2\f\u0010\u0014\u001a\b\u0012\u0004\u0012\u00028\b0\u000b2\f\u0010\u0015\u001a\b\u0012\u0004\u0012\u00028\t0\u000b2\f\u0010\u001b\u001a\b\u0012\u0004\u0012\u00028\n0\u000b2\f\u0010\u001f\u001a\b\u0012\u0004\u0012\u00028\u000b0\u000b2\f\u0010#\u001a\b\u0012\u0004\u0012\u00028\f0\u000b2\f\u0010'\u001a\b\u0012\u0004\u0012\u00028\r0\u000b2`\u0010\u0017\u001a\\\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u0001\u0012\u0004\u0012\u00028\u0002\u0012\u0004\u0012\u00028\u0003\u0012\u0004\u0012\u00028\u0004\u0012\u0004\u0012\u00028\u0005\u0012\u0004\u0012\u00028\u0006\u0012\u0004\u0012\u00028\u0007\u0012\u0004\u0012\u00028\b\u0012\u0004\u0012\u00028\t\u0012\u0004\u0012\u00028\n\u0012\u0004\u0012\u00028\u000b\u0012\u0004\u0012\u00028\f\u0012\u0004\u0012\u00028\r\u0012\u0004\u0012\u00028\u000e0(¢\u0006\u0004\b\u0018\u0010)\u001a\u00ad\u0003\u0010\u0018\u001a\b\u0012\u0004\u0012\u00028\u000f0\u000b\"\u0004\b\u0000\u0010\u0000\"\u0004\b\u0001\u0010\u0001\"\u0004\b\u0002\u0010\u0002\"\u0004\b\u0003\u0010\u0003\"\u0004\b\u0004\u0010\u0004\"\u0004\b\u0005\u0010\u0005\"\u0004\b\u0006\u0010\u0006\"\u0004\b\u0007\u0010\u0007\"\u0004\b\b\u0010\b\"\u0004\b\t\u0010\t\"\u0004\b\n\u0010\u001a\"\u0004\b\u000b\u0010\u001e\"\u0004\b\f\u0010\"\"\u0004\b\r\u0010&\"\u0004\b\u000e\u0010*\"\u0004\b\u000f\u0010\n2\f\u0010\f\u001a\b\u0012\u0004\u0012\u00028\u00000\u000b2\f\u0010\r\u001a\b\u0012\u0004\u0012\u00028\u00010\u000b2\f\u0010\u000e\u001a\b\u0012\u0004\u0012\u00028\u00020\u000b2\f\u0010\u000f\u001a\b\u0012\u0004\u0012\u00028\u00030\u000b2\f\u0010\u0010\u001a\b\u0012\u0004\u0012\u00028\u00040\u000b2\f\u0010\u0011\u001a\b\u0012\u0004\u0012\u00028\u00050\u000b2\f\u0010\u0012\u001a\b\u0012\u0004\u0012\u00028\u00060\u000b2\f\u0010\u0013\u001a\b\u0012\u0004\u0012\u00028\u00070\u000b2\f\u0010\u0014\u001a\b\u0012\u0004\u0012\u00028\b0\u000b2\f\u0010\u0015\u001a\b\u0012\u0004\u0012\u00028\t0\u000b2\f\u0010\u001b\u001a\b\u0012\u0004\u0012\u00028\n0\u000b2\f\u0010\u001f\u001a\b\u0012\u0004\u0012\u00028\u000b0\u000b2\f\u0010#\u001a\b\u0012\u0004\u0012\u00028\f0\u000b2\f\u0010'\u001a\b\u0012\u0004\u0012\u00028\r0\u000b2\f\u0010+\u001a\b\u0012\u0004\u0012\u00028\u000e0\u000b2f\u0010\u0017\u001ab\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u0001\u0012\u0004\u0012\u00028\u0002\u0012\u0004\u0012\u00028\u0003\u0012\u0004\u0012\u00028\u0004\u0012\u0004\u0012\u00028\u0005\u0012\u0004\u0012\u00028\u0006\u0012\u0004\u0012\u00028\u0007\u0012\u0004\u0012\u00028\b\u0012\u0004\u0012\u00028\t\u0012\u0004\u0012\u00028\n\u0012\u0004\u0012\u00028\u000b\u0012\u0004\u0012\u00028\f\u0012\u0004\u0012\u00028\r\u0012\u0004\u0012\u00028\u000e\u0012\u0004\u0012\u00028\u000f0,¢\u0006\u0004\b\u0018\u0010-\u001aÇ\u0003\u0010\u0018\u001a\b\u0012\u0004\u0012\u00028\u00100\u000b\"\u0004\b\u0000\u0010\u0000\"\u0004\b\u0001\u0010\u0001\"\u0004\b\u0002\u0010\u0002\"\u0004\b\u0003\u0010\u0003\"\u0004\b\u0004\u0010\u0004\"\u0004\b\u0005\u0010\u0005\"\u0004\b\u0006\u0010\u0006\"\u0004\b\u0007\u0010\u0007\"\u0004\b\b\u0010\b\"\u0004\b\t\u0010\t\"\u0004\b\n\u0010\u001a\"\u0004\b\u000b\u0010\u001e\"\u0004\b\f\u0010\"\"\u0004\b\r\u0010&\"\u0004\b\u000e\u0010*\"\u0004\b\u000f\u0010.\"\u0004\b\u0010\u0010\n2\f\u0010\f\u001a\b\u0012\u0004\u0012\u00028\u00000\u000b2\f\u0010\r\u001a\b\u0012\u0004\u0012\u00028\u00010\u000b2\f\u0010\u000e\u001a\b\u0012\u0004\u0012\u00028\u00020\u000b2\f\u0010\u000f\u001a\b\u0012\u0004\u0012\u00028\u00030\u000b2\f\u0010\u0010\u001a\b\u0012\u0004\u0012\u00028\u00040\u000b2\f\u0010\u0011\u001a\b\u0012\u0004\u0012\u00028\u00050\u000b2\f\u0010\u0012\u001a\b\u0012\u0004\u0012\u00028\u00060\u000b2\f\u0010\u0013\u001a\b\u0012\u0004\u0012\u00028\u00070\u000b2\f\u0010\u0014\u001a\b\u0012\u0004\u0012\u00028\b0\u000b2\f\u0010\u0015\u001a\b\u0012\u0004\u0012\u00028\t0\u000b2\f\u0010\u001b\u001a\b\u0012\u0004\u0012\u00028\n0\u000b2\f\u0010\u001f\u001a\b\u0012\u0004\u0012\u00028\u000b0\u000b2\f\u0010#\u001a\b\u0012\u0004\u0012\u00028\f0\u000b2\f\u0010'\u001a\b\u0012\u0004\u0012\u00028\r0\u000b2\f\u0010+\u001a\b\u0012\u0004\u0012\u00028\u000e0\u000b2\f\u0010/\u001a\b\u0012\u0004\u0012\u00028\u000f0\u000b2l\u0010\u0017\u001ah\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u0001\u0012\u0004\u0012\u00028\u0002\u0012\u0004\u0012\u00028\u0003\u0012\u0004\u0012\u00028\u0004\u0012\u0004\u0012\u00028\u0005\u0012\u0004\u0012\u00028\u0006\u0012\u0004\u0012\u00028\u0007\u0012\u0004\u0012\u00028\b\u0012\u0004\u0012\u00028\t\u0012\u0004\u0012\u00028\n\u0012\u0004\u0012\u00028\u000b\u0012\u0004\u0012\u00028\f\u0012\u0004\u0012\u00028\r\u0012\u0004\u0012\u00028\u000e\u0012\u0004\u0012\u00028\u000f\u0012\u0004\u0012\u00028\u001000¢\u0006\u0004\b\u0018\u00101\u001aá\u0003\u0010\u0018\u001a\b\u0012\u0004\u0012\u00028\u00110\u000b\"\u0004\b\u0000\u0010\u0000\"\u0004\b\u0001\u0010\u0001\"\u0004\b\u0002\u0010\u0002\"\u0004\b\u0003\u0010\u0003\"\u0004\b\u0004\u0010\u0004\"\u0004\b\u0005\u0010\u0005\"\u0004\b\u0006\u0010\u0006\"\u0004\b\u0007\u0010\u0007\"\u0004\b\b\u0010\b\"\u0004\b\t\u0010\t\"\u0004\b\n\u0010\u001a\"\u0004\b\u000b\u0010\u001e\"\u0004\b\f\u0010\"\"\u0004\b\r\u0010&\"\u0004\b\u000e\u0010*\"\u0004\b\u000f\u0010.\"\u0004\b\u0010\u00102\"\u0004\b\u0011\u0010\n2\f\u0010\f\u001a\b\u0012\u0004\u0012\u00028\u00000\u000b2\f\u0010\r\u001a\b\u0012\u0004\u0012\u00028\u00010\u000b2\f\u0010\u000e\u001a\b\u0012\u0004\u0012\u00028\u00020\u000b2\f\u0010\u000f\u001a\b\u0012\u0004\u0012\u00028\u00030\u000b2\f\u0010\u0010\u001a\b\u0012\u0004\u0012\u00028\u00040\u000b2\f\u0010\u0011\u001a\b\u0012\u0004\u0012\u00028\u00050\u000b2\f\u0010\u0012\u001a\b\u0012\u0004\u0012\u00028\u00060\u000b2\f\u0010\u0013\u001a\b\u0012\u0004\u0012\u00028\u00070\u000b2\f\u0010\u0014\u001a\b\u0012\u0004\u0012\u00028\b0\u000b2\f\u0010\u0015\u001a\b\u0012\u0004\u0012\u00028\t0\u000b2\f\u0010\u001b\u001a\b\u0012\u0004\u0012\u00028\n0\u000b2\f\u0010\u001f\u001a\b\u0012\u0004\u0012\u00028\u000b0\u000b2\f\u0010#\u001a\b\u0012\u0004\u0012\u00028\f0\u000b2\f\u0010'\u001a\b\u0012\u0004\u0012\u00028\r0\u000b2\f\u0010+\u001a\b\u0012\u0004\u0012\u00028\u000e0\u000b2\f\u0010/\u001a\b\u0012\u0004\u0012\u00028\u000f0\u000b2\f\u00103\u001a\b\u0012\u0004\u0012\u00028\u00100\u000b2r\u0010\u0017\u001an\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u0001\u0012\u0004\u0012\u00028\u0002\u0012\u0004\u0012\u00028\u0003\u0012\u0004\u0012\u00028\u0004\u0012\u0004\u0012\u00028\u0005\u0012\u0004\u0012\u00028\u0006\u0012\u0004\u0012\u00028\u0007\u0012\u0004\u0012\u00028\b\u0012\u0004\u0012\u00028\t\u0012\u0004\u0012\u00028\n\u0012\u0004\u0012\u00028\u000b\u0012\u0004\u0012\u00028\f\u0012\u0004\u0012\u00028\r\u0012\u0004\u0012\u00028\u000e\u0012\u0004\u0012\u00028\u000f\u0012\u0004\u0012\u00028\u0010\u0012\u0004\u0012\u00028\u001104¢\u0006\u0004\b\u0018\u00105\u001aå\u0004\u0010\u0018\u001a\b\u0012\u0004\u0012\u00028\u00160\u000b\"\u0004\b\u0000\u0010\u0000\"\u0004\b\u0001\u0010\u0001\"\u0004\b\u0002\u0010\u0002\"\u0004\b\u0003\u0010\u0003\"\u0004\b\u0004\u0010\u0004\"\u0004\b\u0005\u0010\u0005\"\u0004\b\u0006\u0010\u0006\"\u0004\b\u0007\u0010\u0007\"\u0004\b\b\u0010\b\"\u0004\b\t\u0010\t\"\u0004\b\n\u0010\u001a\"\u0004\b\u000b\u0010\u001e\"\u0004\b\f\u0010\"\"\u0004\b\r\u0010&\"\u0004\b\u000e\u0010*\"\u0004\b\u000f\u0010.\"\u0004\b\u0010\u00102\"\u0004\b\u0011\u00106\"\u0004\b\u0012\u00107\"\u0004\b\u0013\u00108\"\u0004\b\u0014\u00109\"\u0004\b\u0015\u0010:\"\u0004\b\u0016\u0010\n2\f\u0010\f\u001a\b\u0012\u0004\u0012\u00028\u00000\u000b2\f\u0010\r\u001a\b\u0012\u0004\u0012\u00028\u00010\u000b2\f\u0010\u000e\u001a\b\u0012\u0004\u0012\u00028\u00020\u000b2\f\u0010\u000f\u001a\b\u0012\u0004\u0012\u00028\u00030\u000b2\f\u0010\u0010\u001a\b\u0012\u0004\u0012\u00028\u00040\u000b2\f\u0010\u0011\u001a\b\u0012\u0004\u0012\u00028\u00050\u000b2\f\u0010\u0012\u001a\b\u0012\u0004\u0012\u00028\u00060\u000b2\f\u0010\u0013\u001a\b\u0012\u0004\u0012\u00028\u00070\u000b2\f\u0010\u0014\u001a\b\u0012\u0004\u0012\u00028\b0\u000b2\f\u0010\u0015\u001a\b\u0012\u0004\u0012\u00028\t0\u000b2\f\u0010\u001b\u001a\b\u0012\u0004\u0012\u00028\n0\u000b2\f\u0010\u001f\u001a\b\u0012\u0004\u0012\u00028\u000b0\u000b2\f\u0010#\u001a\b\u0012\u0004\u0012\u00028\f0\u000b2\f\u0010'\u001a\b\u0012\u0004\u0012\u00028\r0\u000b2\f\u0010+\u001a\b\u0012\u0004\u0012\u00028\u000e0\u000b2\f\u0010/\u001a\b\u0012\u0004\u0012\u00028\u000f0\u000b2\f\u00103\u001a\b\u0012\u0004\u0012\u00028\u00100\u000b2\f\u0010;\u001a\b\u0012\u0004\u0012\u00028\u00110\u000b2\f\u0010<\u001a\b\u0012\u0004\u0012\u00028\u00120\u000b2\f\u0010=\u001a\b\u0012\u0004\u0012\u00028\u00130\u000b2\f\u0010>\u001a\b\u0012\u0004\u0012\u00028\u00140\u000b2\f\u0010?\u001a\b\u0012\u0004\u0012\u00028\u00150\u000b2\u0091\u0001\u0010\u0017\u001a\u008c\u0001\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u0001\u0012\u0004\u0012\u00028\u0002\u0012\u0004\u0012\u00028\u0003\u0012\u0004\u0012\u00028\u0004\u0012\u0004\u0012\u00028\u0005\u0012\u0004\u0012\u00028\u0006\u0012\u0004\u0012\u00028\u0007\u0012\u0004\u0012\u00028\b\u0012\u0004\u0012\u00028\t\u0012\u0004\u0012\u00028\n\u0012\u0004\u0012\u00028\u000b\u0012\u0004\u0012\u00028\f\u0012\u0004\u0012\u00028\r\u0012\u0004\u0012\u00028\u000e\u0012\u0004\u0012\u00028\u000f\u0012\u0004\u0012\u00028\u0010\u0012\u0004\u0012\u00028\u0011\u0012\u0004\u0012\u00028\u0012\u0012\u0004\u0012\u00028\u0013\u0012\u0004\u0012\u00028\u0014\u0012\u0004\u0012\u00028\u0015\u0012\u0004\u0012\u00028\u00160@¢\u0006\u0004\b\u0018\u0010A\u001aÿ\u0001\u0010C\u001a>\u0012:\u00128\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u0001\u0012\u0004\u0012\u00028\u0002\u0012\u0004\u0012\u00028\u0003\u0012\u0004\u0012\u00028\u0004\u0012\u0004\u0012\u00028\u0005\u0012\u0004\u0012\u00028\u0006\u0012\u0004\u0012\u00028\u0007\u0012\u0004\u0012\u00028\b0B0\u000b\"\u0004\b\u0000\u0010\u0000\"\u0004\b\u0001\u0010\u0001\"\u0004\b\u0002\u0010\u0002\"\u0004\b\u0003\u0010\u0003\"\u0004\b\u0004\u0010\u0004\"\u0004\b\u0005\u0010\u0005\"\u0004\b\u0006\u0010\u0006\"\u0004\b\u0007\u0010\u0007\"\u0004\b\b\u0010\b2\f\u0010\f\u001a\b\u0012\u0004\u0012\u00028\u00000\u000b2\f\u0010\r\u001a\b\u0012\u0004\u0012\u00028\u00010\u000b2\f\u0010\u000e\u001a\b\u0012\u0004\u0012\u00028\u00020\u000b2\f\u0010\u000f\u001a\b\u0012\u0004\u0012\u00028\u00030\u000b2\f\u0010\u0010\u001a\b\u0012\u0004\u0012\u00028\u00040\u000b2\f\u0010\u0011\u001a\b\u0012\u0004\u0012\u00028\u00050\u000b2\f\u0010\u0012\u001a\b\u0012\u0004\u0012\u00028\u00060\u000b2\f\u0010\u0013\u001a\b\u0012\u0004\u0012\u00028\u00070\u000b2\f\u0010\u0014\u001a\b\u0012\u0004\u0012\u00028\b0\u000bH\u0002¢\u0006\u0004\bC\u0010D¨\u0006E"}, d2 = {"T1", "T2", "T3", "T4", "T5", "T6", "T7", "T8", "T9", "T10", "R", "Lrx/Observable;", "o1", "o2", "o3", "o4", "o5", "o6", "o7", "o8", "o9", "o10", "Lkotlin/Function10;", "combineFunction", "combineLatest", "(Lrx/Observable;Lrx/Observable;Lrx/Observable;Lrx/Observable;Lrx/Observable;Lrx/Observable;Lrx/Observable;Lrx/Observable;Lrx/Observable;Lrx/Observable;Lkotlin/jvm/functions/Function10;)Lrx/Observable;", "T11", "o11", "Lkotlin/Function11;", "(Lrx/Observable;Lrx/Observable;Lrx/Observable;Lrx/Observable;Lrx/Observable;Lrx/Observable;Lrx/Observable;Lrx/Observable;Lrx/Observable;Lrx/Observable;Lrx/Observable;Lkotlin/jvm/functions/Function11;)Lrx/Observable;", "T12", "o12", "Lkotlin/Function12;", "(Lrx/Observable;Lrx/Observable;Lrx/Observable;Lrx/Observable;Lrx/Observable;Lrx/Observable;Lrx/Observable;Lrx/Observable;Lrx/Observable;Lrx/Observable;Lrx/Observable;Lrx/Observable;Lkotlin/jvm/functions/Function12;)Lrx/Observable;", "T13", "o13", "Lkotlin/Function13;", "(Lrx/Observable;Lrx/Observable;Lrx/Observable;Lrx/Observable;Lrx/Observable;Lrx/Observable;Lrx/Observable;Lrx/Observable;Lrx/Observable;Lrx/Observable;Lrx/Observable;Lrx/Observable;Lrx/Observable;Lkotlin/jvm/functions/Function13;)Lrx/Observable;", "T14", "o14", "Lkotlin/Function14;", "(Lrx/Observable;Lrx/Observable;Lrx/Observable;Lrx/Observable;Lrx/Observable;Lrx/Observable;Lrx/Observable;Lrx/Observable;Lrx/Observable;Lrx/Observable;Lrx/Observable;Lrx/Observable;Lrx/Observable;Lrx/Observable;Lkotlin/jvm/functions/Function14;)Lrx/Observable;", "T15", "o15", "Lkotlin/Function15;", "(Lrx/Observable;Lrx/Observable;Lrx/Observable;Lrx/Observable;Lrx/Observable;Lrx/Observable;Lrx/Observable;Lrx/Observable;Lrx/Observable;Lrx/Observable;Lrx/Observable;Lrx/Observable;Lrx/Observable;Lrx/Observable;Lrx/Observable;Lkotlin/jvm/functions/Function15;)Lrx/Observable;", "T16", "o16", "Lkotlin/Function16;", "(Lrx/Observable;Lrx/Observable;Lrx/Observable;Lrx/Observable;Lrx/Observable;Lrx/Observable;Lrx/Observable;Lrx/Observable;Lrx/Observable;Lrx/Observable;Lrx/Observable;Lrx/Observable;Lrx/Observable;Lrx/Observable;Lrx/Observable;Lrx/Observable;Lkotlin/jvm/functions/Function16;)Lrx/Observable;", "T17", "o17", "Lkotlin/Function17;", "(Lrx/Observable;Lrx/Observable;Lrx/Observable;Lrx/Observable;Lrx/Observable;Lrx/Observable;Lrx/Observable;Lrx/Observable;Lrx/Observable;Lrx/Observable;Lrx/Observable;Lrx/Observable;Lrx/Observable;Lrx/Observable;Lrx/Observable;Lrx/Observable;Lrx/Observable;Lkotlin/jvm/functions/Function17;)Lrx/Observable;", "T18", "T19", "T20", "T21", "T22", "o18", "o19", "o20", "o21", "o22", "Lkotlin/Function22;", "(Lrx/Observable;Lrx/Observable;Lrx/Observable;Lrx/Observable;Lrx/Observable;Lrx/Observable;Lrx/Observable;Lrx/Observable;Lrx/Observable;Lrx/Observable;Lrx/Observable;Lrx/Observable;Lrx/Observable;Lrx/Observable;Lrx/Observable;Lrx/Observable;Lrx/Observable;Lrx/Observable;Lrx/Observable;Lrx/Observable;Lrx/Observable;Lrx/Observable;Lkotlin/jvm/functions/Function22;)Lrx/Observable;", "Lcom/discord/utilities/rx/Holder;", "createHolderObservable", "(Lrx/Observable;Lrx/Observable;Lrx/Observable;Lrx/Observable;Lrx/Observable;Lrx/Observable;Lrx/Observable;Lrx/Observable;Lrx/Observable;)Lrx/Observable;", "utils_release"}, k = 2, mv = {1, 4, 2})
/* renamed from: com.discord.utilities.rx.ObservableCombineLatestOverloadsKt, reason: use source file name */
/* loaded from: classes2.dex */
public final class ObservableCombineLatestOverloads2 {

    /* JADX INFO: Add missing generic type declarations: [T4, T5, T6, T10, T7, T8, T9, T3] */
    /* compiled from: ObservableCombineLatestOverloads.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\f\n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0002\b\u0006\u0010\u0011\u001a\n \f*\u0004\u0018\u00018\n8\n\"\u0004\b\u0000\u0010\u0000\"\u0004\b\u0001\u0010\u0001\"\u0004\b\u0002\u0010\u0002\"\u0004\b\u0003\u0010\u0003\"\u0004\b\u0004\u0010\u0004\"\u0004\b\u0005\u0010\u0005\"\u0004\b\u0006\u0010\u0006\"\u0004\b\u0007\u0010\u0007\"\u0004\b\b\u0010\b\"\u0004\b\t\u0010\t\"\u0004\b\n\u0010\n2z\u0010\r\u001av\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u0001\u0012\u0004\u0012\u00028\u0002\u0012\u0004\u0012\u00028\u0003\u0012\u0004\u0012\u00028\u0004\u0012\u0004\u0012\u00028\u0005\u0012\u0004\u0012\u00028\u0006\u0012\u0004\u0012\u00028\u0007\u0012\u0004\u0012\u00028\b \f*:\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u0001\u0012\u0004\u0012\u00028\u0002\u0012\u0004\u0012\u00028\u0003\u0012\u0004\u0012\u00028\u0004\u0012\u0004\u0012\u00028\u0005\u0012\u0004\u0012\u00028\u0006\u0012\u0004\u0012\u00028\u0007\u0012\u0004\u0012\u00028\b\u0018\u00010\u000b0\u000b2\u000e\u0010\u000e\u001a\n \f*\u0004\u0018\u00018\t8\tH\n¢\u0006\u0004\b\u000f\u0010\u0010"}, d2 = {"T1", "T2", "T3", "T4", "T5", "T6", "T7", "T8", "T9", "T10", "R", "Lcom/discord/utilities/rx/Holder;", "kotlin.jvm.PlatformType", "holder", "t10", NotificationCompat.CATEGORY_CALL, "(Lcom/discord/utilities/rx/Holder;Ljava/lang/Object;)Ljava/lang/Object;", "<anonymous>"}, k = 3, mv = {1, 4, 2})
    /* renamed from: com.discord.utilities.rx.ObservableCombineLatestOverloadsKt$combineLatest$1, reason: invalid class name */
    public static final class AnonymousClass1<T1, T2, R, T10, T3, T4, T5, T6, T7, T8, T9> implements Func2<ObservableCombineLatestOverloads<T1, T2, T3, T4, T5, T6, T7, T8, T9>, T10, R> {
        public final /* synthetic */ Function10 $combineFunction;

        public AnonymousClass1(Function10 function10) {
            this.$combineFunction = function10;
        }

        public final R call(ObservableCombineLatestOverloads<T1, T2, T3, T4, T5, T6, T7, T8, T9> observableCombineLatestOverloads, T10 t10) {
            return (R) this.$combineFunction.invoke(observableCombineLatestOverloads.getT1(), observableCombineLatestOverloads.getT2(), observableCombineLatestOverloads.getT3(), observableCombineLatestOverloads.getT4(), observableCombineLatestOverloads.getT5(), observableCombineLatestOverloads.getT6(), observableCombineLatestOverloads.getT7(), observableCombineLatestOverloads.getT8(), observableCombineLatestOverloads.getT9(), t10);
        }

        /* JADX WARN: Multi-variable type inference failed */
        @Override // rx.functions.Func2
        public /* bridge */ /* synthetic */ Object call(Object obj, Object obj2) {
            return call((ObservableCombineLatestOverloads) obj, (ObservableCombineLatestOverloads<T1, T2, T3, T4, T5, T6, T7, T8, T9>) obj2);
        }
    }

    /* JADX INFO: Add missing generic type declarations: [T4, T5, T6, T10, T7, T8, T9, T11] */
    /* compiled from: ObservableCombineLatestOverloads.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\f\n\u0002\b\f\n\u0002\u0018\u0002\n\u0002\b\u0007\u0010\u0013\u001a\n \r*\u0004\u0018\u00018\u000b8\u000b\"\u0004\b\u0000\u0010\u0000\"\u0004\b\u0001\u0010\u0001\"\u0004\b\u0002\u0010\u0002\"\u0004\b\u0003\u0010\u0003\"\u0004\b\u0004\u0010\u0004\"\u0004\b\u0005\u0010\u0005\"\u0004\b\u0006\u0010\u0006\"\u0004\b\u0007\u0010\u0007\"\u0004\b\b\u0010\b\"\u0004\b\t\u0010\t\"\u0004\b\n\u0010\n\"\u0004\b\u000b\u0010\u000b2z\u0010\u000e\u001av\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u0001\u0012\u0004\u0012\u00028\u0002\u0012\u0004\u0012\u00028\u0003\u0012\u0004\u0012\u00028\u0004\u0012\u0004\u0012\u00028\u0005\u0012\u0004\u0012\u00028\u0006\u0012\u0004\u0012\u00028\u0007\u0012\u0004\u0012\u00028\b \r*:\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u0001\u0012\u0004\u0012\u00028\u0002\u0012\u0004\u0012\u00028\u0003\u0012\u0004\u0012\u00028\u0004\u0012\u0004\u0012\u00028\u0005\u0012\u0004\u0012\u00028\u0006\u0012\u0004\u0012\u00028\u0007\u0012\u0004\u0012\u00028\b\u0018\u00010\f0\f2\u000e\u0010\u000f\u001a\n \r*\u0004\u0018\u00018\t8\t2\u000e\u0010\u0010\u001a\n \r*\u0004\u0018\u00018\n8\nH\n¢\u0006\u0004\b\u0011\u0010\u0012"}, d2 = {"T1", "T2", "T3", "T4", "T5", "T6", "T7", "T8", "T9", "T10", "T11", "R", "Lcom/discord/utilities/rx/Holder;", "kotlin.jvm.PlatformType", "holder", "t10", "t11", NotificationCompat.CATEGORY_CALL, "(Lcom/discord/utilities/rx/Holder;Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;", "<anonymous>"}, k = 3, mv = {1, 4, 2})
    /* renamed from: com.discord.utilities.rx.ObservableCombineLatestOverloadsKt$combineLatest$2, reason: invalid class name */
    public static final class AnonymousClass2<T1, T2, T3, R, T10, T11, T4, T5, T6, T7, T8, T9> implements Func3<ObservableCombineLatestOverloads<T1, T2, T3, T4, T5, T6, T7, T8, T9>, T10, T11, R> {
        public final /* synthetic */ Function11 $combineFunction;

        public AnonymousClass2(Function11 function11) {
            this.$combineFunction = function11;
        }

        public final R call(ObservableCombineLatestOverloads<T1, T2, T3, T4, T5, T6, T7, T8, T9> observableCombineLatestOverloads, T10 t10, T11 t11) {
            return (R) this.$combineFunction.invoke(observableCombineLatestOverloads.getT1(), observableCombineLatestOverloads.getT2(), observableCombineLatestOverloads.getT3(), observableCombineLatestOverloads.getT4(), observableCombineLatestOverloads.getT5(), observableCombineLatestOverloads.getT6(), observableCombineLatestOverloads.getT7(), observableCombineLatestOverloads.getT8(), observableCombineLatestOverloads.getT9(), t10, t11);
        }

        /* JADX WARN: Multi-variable type inference failed */
        @Override // rx.functions.Func3
        public /* bridge */ /* synthetic */ Object call(Object obj, Object obj2, Object obj3) {
            return call((ObservableCombineLatestOverloads) obj, (ObservableCombineLatestOverloads<T1, T2, T3, T4, T5, T6, T7, T8, T9>) obj2, obj3);
        }
    }

    /* JADX INFO: Add missing generic type declarations: [T5, T6, T7, T8, T9, T10, T12, T11] */
    /* compiled from: ObservableCombineLatestOverloads.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\f\n\u0002\b\r\n\u0002\u0018\u0002\n\u0002\b\b\u0010\u0015\u001a\n \u000e*\u0004\u0018\u00018\f8\f\"\u0004\b\u0000\u0010\u0000\"\u0004\b\u0001\u0010\u0001\"\u0004\b\u0002\u0010\u0002\"\u0004\b\u0003\u0010\u0003\"\u0004\b\u0004\u0010\u0004\"\u0004\b\u0005\u0010\u0005\"\u0004\b\u0006\u0010\u0006\"\u0004\b\u0007\u0010\u0007\"\u0004\b\b\u0010\b\"\u0004\b\t\u0010\t\"\u0004\b\n\u0010\n\"\u0004\b\u000b\u0010\u000b\"\u0004\b\f\u0010\f2z\u0010\u000f\u001av\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u0001\u0012\u0004\u0012\u00028\u0002\u0012\u0004\u0012\u00028\u0003\u0012\u0004\u0012\u00028\u0004\u0012\u0004\u0012\u00028\u0005\u0012\u0004\u0012\u00028\u0006\u0012\u0004\u0012\u00028\u0007\u0012\u0004\u0012\u00028\b \u000e*:\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u0001\u0012\u0004\u0012\u00028\u0002\u0012\u0004\u0012\u00028\u0003\u0012\u0004\u0012\u00028\u0004\u0012\u0004\u0012\u00028\u0005\u0012\u0004\u0012\u00028\u0006\u0012\u0004\u0012\u00028\u0007\u0012\u0004\u0012\u00028\b\u0018\u00010\r0\r2\u000e\u0010\u0010\u001a\n \u000e*\u0004\u0018\u00018\t8\t2\u000e\u0010\u0011\u001a\n \u000e*\u0004\u0018\u00018\n8\n2\u000e\u0010\u0012\u001a\n \u000e*\u0004\u0018\u00018\u000b8\u000bH\n¢\u0006\u0004\b\u0013\u0010\u0014"}, d2 = {"T1", "T2", "T3", "T4", "T5", "T6", "T7", "T8", "T9", "T10", "T11", "T12", "R", "Lcom/discord/utilities/rx/Holder;", "kotlin.jvm.PlatformType", "holder", "t10", "t11", "t12", NotificationCompat.CATEGORY_CALL, "(Lcom/discord/utilities/rx/Holder;Ljava/lang/Object;Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;", "<anonymous>"}, k = 3, mv = {1, 4, 2})
    /* renamed from: com.discord.utilities.rx.ObservableCombineLatestOverloadsKt$combineLatest$3, reason: invalid class name */
    public static final class AnonymousClass3<T1, T2, T3, T4, R, T10, T11, T12, T5, T6, T7, T8, T9> implements Func4<ObservableCombineLatestOverloads<T1, T2, T3, T4, T5, T6, T7, T8, T9>, T10, T11, T12, R> {
        public final /* synthetic */ Function12 $combineFunction;

        public AnonymousClass3(Function12 function12) {
            this.$combineFunction = function12;
        }

        public final R call(ObservableCombineLatestOverloads<T1, T2, T3, T4, T5, T6, T7, T8, T9> observableCombineLatestOverloads, T10 t10, T11 t11, T12 t12) {
            return (R) this.$combineFunction.invoke(observableCombineLatestOverloads.getT1(), observableCombineLatestOverloads.getT2(), observableCombineLatestOverloads.getT3(), observableCombineLatestOverloads.getT4(), observableCombineLatestOverloads.getT5(), observableCombineLatestOverloads.getT6(), observableCombineLatestOverloads.getT7(), observableCombineLatestOverloads.getT8(), observableCombineLatestOverloads.getT9(), t10, t11, t12);
        }

        /* JADX WARN: Multi-variable type inference failed */
        @Override // rx.functions.Func4
        public /* bridge */ /* synthetic */ Object call(Object obj, Object obj2, Object obj3, Object obj4) {
            return call((ObservableCombineLatestOverloads) obj, (ObservableCombineLatestOverloads<T1, T2, T3, T4, T5, T6, T7, T8, T9>) obj2, obj3, obj4);
        }
    }

    /* JADX INFO: Add missing generic type declarations: [T6, T7, T8, T9, T10, T12, T11, T13] */
    /* compiled from: ObservableCombineLatestOverloads.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\f\n\u0002\b\u000e\n\u0002\u0018\u0002\n\u0002\b\t\u0010\u0017\u001a\n \u000f*\u0004\u0018\u00018\r8\r\"\u0004\b\u0000\u0010\u0000\"\u0004\b\u0001\u0010\u0001\"\u0004\b\u0002\u0010\u0002\"\u0004\b\u0003\u0010\u0003\"\u0004\b\u0004\u0010\u0004\"\u0004\b\u0005\u0010\u0005\"\u0004\b\u0006\u0010\u0006\"\u0004\b\u0007\u0010\u0007\"\u0004\b\b\u0010\b\"\u0004\b\t\u0010\t\"\u0004\b\n\u0010\n\"\u0004\b\u000b\u0010\u000b\"\u0004\b\f\u0010\f\"\u0004\b\r\u0010\r2z\u0010\u0010\u001av\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u0001\u0012\u0004\u0012\u00028\u0002\u0012\u0004\u0012\u00028\u0003\u0012\u0004\u0012\u00028\u0004\u0012\u0004\u0012\u00028\u0005\u0012\u0004\u0012\u00028\u0006\u0012\u0004\u0012\u00028\u0007\u0012\u0004\u0012\u00028\b \u000f*:\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u0001\u0012\u0004\u0012\u00028\u0002\u0012\u0004\u0012\u00028\u0003\u0012\u0004\u0012\u00028\u0004\u0012\u0004\u0012\u00028\u0005\u0012\u0004\u0012\u00028\u0006\u0012\u0004\u0012\u00028\u0007\u0012\u0004\u0012\u00028\b\u0018\u00010\u000e0\u000e2\u000e\u0010\u0011\u001a\n \u000f*\u0004\u0018\u00018\t8\t2\u000e\u0010\u0012\u001a\n \u000f*\u0004\u0018\u00018\n8\n2\u000e\u0010\u0013\u001a\n \u000f*\u0004\u0018\u00018\u000b8\u000b2\u000e\u0010\u0014\u001a\n \u000f*\u0004\u0018\u00018\f8\fH\n¢\u0006\u0004\b\u0015\u0010\u0016"}, d2 = {"T1", "T2", "T3", "T4", "T5", "T6", "T7", "T8", "T9", "T10", "T11", "T12", "T13", "R", "Lcom/discord/utilities/rx/Holder;", "kotlin.jvm.PlatformType", "holder", "t10", "t11", "t12", "t13", NotificationCompat.CATEGORY_CALL, "(Lcom/discord/utilities/rx/Holder;Ljava/lang/Object;Ljava/lang/Object;Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;", "<anonymous>"}, k = 3, mv = {1, 4, 2})
    /* renamed from: com.discord.utilities.rx.ObservableCombineLatestOverloadsKt$combineLatest$4, reason: invalid class name */
    public static final class AnonymousClass4<T1, T2, T3, T4, T5, R, T10, T11, T12, T13, T6, T7, T8, T9> implements Func5<ObservableCombineLatestOverloads<T1, T2, T3, T4, T5, T6, T7, T8, T9>, T10, T11, T12, T13, R> {
        public final /* synthetic */ Function13 $combineFunction;

        public AnonymousClass4(Function13 function13) {
            this.$combineFunction = function13;
        }

        public final R call(ObservableCombineLatestOverloads<T1, T2, T3, T4, T5, T6, T7, T8, T9> observableCombineLatestOverloads, T10 t10, T11 t11, T12 t12, T13 t13) {
            return (R) this.$combineFunction.invoke(observableCombineLatestOverloads.getT1(), observableCombineLatestOverloads.getT2(), observableCombineLatestOverloads.getT3(), observableCombineLatestOverloads.getT4(), observableCombineLatestOverloads.getT5(), observableCombineLatestOverloads.getT6(), observableCombineLatestOverloads.getT7(), observableCombineLatestOverloads.getT8(), observableCombineLatestOverloads.getT9(), t10, t11, t12, t13);
        }

        /* JADX WARN: Multi-variable type inference failed */
        @Override // rx.functions.Func5
        public /* bridge */ /* synthetic */ Object call(Object obj, Object obj2, Object obj3, Object obj4, Object obj5) {
            return call((ObservableCombineLatestOverloads) obj, (ObservableCombineLatestOverloads<T1, T2, T3, T4, T5, T6, T7, T8, T9>) obj2, obj3, obj4, obj5);
        }
    }

    /* JADX INFO: Add missing generic type declarations: [T7, T8, T9, T10, T12, T11, T14, T13] */
    /* compiled from: ObservableCombineLatestOverloads.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\f\n\u0002\b\u000f\n\u0002\u0018\u0002\n\u0002\b\n\u0010\u0019\u001a\n \u0010*\u0004\u0018\u00018\u000e8\u000e\"\u0004\b\u0000\u0010\u0000\"\u0004\b\u0001\u0010\u0001\"\u0004\b\u0002\u0010\u0002\"\u0004\b\u0003\u0010\u0003\"\u0004\b\u0004\u0010\u0004\"\u0004\b\u0005\u0010\u0005\"\u0004\b\u0006\u0010\u0006\"\u0004\b\u0007\u0010\u0007\"\u0004\b\b\u0010\b\"\u0004\b\t\u0010\t\"\u0004\b\n\u0010\n\"\u0004\b\u000b\u0010\u000b\"\u0004\b\f\u0010\f\"\u0004\b\r\u0010\r\"\u0004\b\u000e\u0010\u000e2z\u0010\u0011\u001av\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u0001\u0012\u0004\u0012\u00028\u0002\u0012\u0004\u0012\u00028\u0003\u0012\u0004\u0012\u00028\u0004\u0012\u0004\u0012\u00028\u0005\u0012\u0004\u0012\u00028\u0006\u0012\u0004\u0012\u00028\u0007\u0012\u0004\u0012\u00028\b \u0010*:\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u0001\u0012\u0004\u0012\u00028\u0002\u0012\u0004\u0012\u00028\u0003\u0012\u0004\u0012\u00028\u0004\u0012\u0004\u0012\u00028\u0005\u0012\u0004\u0012\u00028\u0006\u0012\u0004\u0012\u00028\u0007\u0012\u0004\u0012\u00028\b\u0018\u00010\u000f0\u000f2\u000e\u0010\u0012\u001a\n \u0010*\u0004\u0018\u00018\t8\t2\u000e\u0010\u0013\u001a\n \u0010*\u0004\u0018\u00018\n8\n2\u000e\u0010\u0014\u001a\n \u0010*\u0004\u0018\u00018\u000b8\u000b2\u000e\u0010\u0015\u001a\n \u0010*\u0004\u0018\u00018\f8\f2\u000e\u0010\u0016\u001a\n \u0010*\u0004\u0018\u00018\r8\rH\n¢\u0006\u0004\b\u0017\u0010\u0018"}, d2 = {"T1", "T2", "T3", "T4", "T5", "T6", "T7", "T8", "T9", "T10", "T11", "T12", "T13", "T14", "R", "Lcom/discord/utilities/rx/Holder;", "kotlin.jvm.PlatformType", "holder", "t10", "t11", "t12", "t13", "t14", NotificationCompat.CATEGORY_CALL, "(Lcom/discord/utilities/rx/Holder;Ljava/lang/Object;Ljava/lang/Object;Ljava/lang/Object;Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;", "<anonymous>"}, k = 3, mv = {1, 4, 2})
    /* renamed from: com.discord.utilities.rx.ObservableCombineLatestOverloadsKt$combineLatest$5, reason: invalid class name */
    public static final class AnonymousClass5<T1, T2, T3, T4, T5, T6, R, T10, T11, T12, T13, T14, T7, T8, T9> implements Func6<ObservableCombineLatestOverloads<T1, T2, T3, T4, T5, T6, T7, T8, T9>, T10, T11, T12, T13, T14, R> {
        public final /* synthetic */ Function14 $combineFunction;

        public AnonymousClass5(Function14 function14) {
            this.$combineFunction = function14;
        }

        public final R call(ObservableCombineLatestOverloads<T1, T2, T3, T4, T5, T6, T7, T8, T9> observableCombineLatestOverloads, T10 t10, T11 t11, T12 t12, T13 t13, T14 t14) {
            return (R) this.$combineFunction.invoke(observableCombineLatestOverloads.getT1(), observableCombineLatestOverloads.getT2(), observableCombineLatestOverloads.getT3(), observableCombineLatestOverloads.getT4(), observableCombineLatestOverloads.getT5(), observableCombineLatestOverloads.getT6(), observableCombineLatestOverloads.getT7(), observableCombineLatestOverloads.getT8(), observableCombineLatestOverloads.getT9(), t10, t11, t12, t13, t14);
        }

        /* JADX WARN: Multi-variable type inference failed */
        @Override // rx.functions.Func6
        public /* bridge */ /* synthetic */ Object call(Object obj, Object obj2, Object obj3, Object obj4, Object obj5, Object obj6) {
            return call((ObservableCombineLatestOverloads) obj, (ObservableCombineLatestOverloads<T1, T2, T3, T4, T5, T6, T7, T8, T9>) obj2, obj3, obj4, obj5, obj6);
        }
    }

    /* JADX INFO: Add missing generic type declarations: [T8, T9, T10, T12, T11, T14, T13, T15] */
    /* compiled from: ObservableCombineLatestOverloads.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\f\n\u0002\b\u0010\n\u0002\u0018\u0002\n\u0002\b\u000b\u0010\u001b\u001a\n \u0011*\u0004\u0018\u00018\u000f8\u000f\"\u0004\b\u0000\u0010\u0000\"\u0004\b\u0001\u0010\u0001\"\u0004\b\u0002\u0010\u0002\"\u0004\b\u0003\u0010\u0003\"\u0004\b\u0004\u0010\u0004\"\u0004\b\u0005\u0010\u0005\"\u0004\b\u0006\u0010\u0006\"\u0004\b\u0007\u0010\u0007\"\u0004\b\b\u0010\b\"\u0004\b\t\u0010\t\"\u0004\b\n\u0010\n\"\u0004\b\u000b\u0010\u000b\"\u0004\b\f\u0010\f\"\u0004\b\r\u0010\r\"\u0004\b\u000e\u0010\u000e\"\u0004\b\u000f\u0010\u000f2z\u0010\u0012\u001av\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u0001\u0012\u0004\u0012\u00028\u0002\u0012\u0004\u0012\u00028\u0003\u0012\u0004\u0012\u00028\u0004\u0012\u0004\u0012\u00028\u0005\u0012\u0004\u0012\u00028\u0006\u0012\u0004\u0012\u00028\u0007\u0012\u0004\u0012\u00028\b \u0011*:\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u0001\u0012\u0004\u0012\u00028\u0002\u0012\u0004\u0012\u00028\u0003\u0012\u0004\u0012\u00028\u0004\u0012\u0004\u0012\u00028\u0005\u0012\u0004\u0012\u00028\u0006\u0012\u0004\u0012\u00028\u0007\u0012\u0004\u0012\u00028\b\u0018\u00010\u00100\u00102\u000e\u0010\u0013\u001a\n \u0011*\u0004\u0018\u00018\t8\t2\u000e\u0010\u0014\u001a\n \u0011*\u0004\u0018\u00018\n8\n2\u000e\u0010\u0015\u001a\n \u0011*\u0004\u0018\u00018\u000b8\u000b2\u000e\u0010\u0016\u001a\n \u0011*\u0004\u0018\u00018\f8\f2\u000e\u0010\u0017\u001a\n \u0011*\u0004\u0018\u00018\r8\r2\u000e\u0010\u0018\u001a\n \u0011*\u0004\u0018\u00018\u000e8\u000eH\n¢\u0006\u0004\b\u0019\u0010\u001a"}, d2 = {"T1", "T2", "T3", "T4", "T5", "T6", "T7", "T8", "T9", "T10", "T11", "T12", "T13", "T14", "T15", "R", "Lcom/discord/utilities/rx/Holder;", "kotlin.jvm.PlatformType", "holder", "t10", "t11", "t12", "t13", "t14", "t15", NotificationCompat.CATEGORY_CALL, "(Lcom/discord/utilities/rx/Holder;Ljava/lang/Object;Ljava/lang/Object;Ljava/lang/Object;Ljava/lang/Object;Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;", "<anonymous>"}, k = 3, mv = {1, 4, 2})
    /* renamed from: com.discord.utilities.rx.ObservableCombineLatestOverloadsKt$combineLatest$6, reason: invalid class name */
    public static final class AnonymousClass6<T1, T2, T3, T4, T5, T6, T7, R, T10, T11, T12, T13, T14, T15, T8, T9> implements Func7<ObservableCombineLatestOverloads<T1, T2, T3, T4, T5, T6, T7, T8, T9>, T10, T11, T12, T13, T14, T15, R> {
        public final /* synthetic */ Function15 $combineFunction;

        public AnonymousClass6(Function15 function15) {
            this.$combineFunction = function15;
        }

        public final R call(ObservableCombineLatestOverloads<T1, T2, T3, T4, T5, T6, T7, T8, T9> observableCombineLatestOverloads, T10 t10, T11 t11, T12 t12, T13 t13, T14 t14, T15 t15) {
            return (R) this.$combineFunction.invoke(observableCombineLatestOverloads.getT1(), observableCombineLatestOverloads.getT2(), observableCombineLatestOverloads.getT3(), observableCombineLatestOverloads.getT4(), observableCombineLatestOverloads.getT5(), observableCombineLatestOverloads.getT6(), observableCombineLatestOverloads.getT7(), observableCombineLatestOverloads.getT8(), observableCombineLatestOverloads.getT9(), t10, t11, t12, t13, t14, t15);
        }

        /* JADX WARN: Multi-variable type inference failed */
        @Override // rx.functions.Func7
        public /* bridge */ /* synthetic */ Object call(Object obj, Object obj2, Object obj3, Object obj4, Object obj5, Object obj6, Object obj7) {
            return call((ObservableCombineLatestOverloads) obj, (ObservableCombineLatestOverloads<T1, T2, T3, T4, T5, T6, T7, T8, T9>) obj2, obj3, obj4, obj5, obj6, obj7);
        }
    }

    /* JADX INFO: Add missing generic type declarations: [T9, T10, T12, T11, T14, T13, T16, T15] */
    /* compiled from: ObservableCombineLatestOverloads.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\f\n\u0002\b\u0011\n\u0002\u0018\u0002\n\u0002\b\f\u0010\u001d\u001a\n \u0012*\u0004\u0018\u00018\u00108\u0010\"\u0004\b\u0000\u0010\u0000\"\u0004\b\u0001\u0010\u0001\"\u0004\b\u0002\u0010\u0002\"\u0004\b\u0003\u0010\u0003\"\u0004\b\u0004\u0010\u0004\"\u0004\b\u0005\u0010\u0005\"\u0004\b\u0006\u0010\u0006\"\u0004\b\u0007\u0010\u0007\"\u0004\b\b\u0010\b\"\u0004\b\t\u0010\t\"\u0004\b\n\u0010\n\"\u0004\b\u000b\u0010\u000b\"\u0004\b\f\u0010\f\"\u0004\b\r\u0010\r\"\u0004\b\u000e\u0010\u000e\"\u0004\b\u000f\u0010\u000f\"\u0004\b\u0010\u0010\u00102z\u0010\u0013\u001av\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u0001\u0012\u0004\u0012\u00028\u0002\u0012\u0004\u0012\u00028\u0003\u0012\u0004\u0012\u00028\u0004\u0012\u0004\u0012\u00028\u0005\u0012\u0004\u0012\u00028\u0006\u0012\u0004\u0012\u00028\u0007\u0012\u0004\u0012\u00028\b \u0012*:\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u0001\u0012\u0004\u0012\u00028\u0002\u0012\u0004\u0012\u00028\u0003\u0012\u0004\u0012\u00028\u0004\u0012\u0004\u0012\u00028\u0005\u0012\u0004\u0012\u00028\u0006\u0012\u0004\u0012\u00028\u0007\u0012\u0004\u0012\u00028\b\u0018\u00010\u00110\u00112\u000e\u0010\u0014\u001a\n \u0012*\u0004\u0018\u00018\t8\t2\u000e\u0010\u0015\u001a\n \u0012*\u0004\u0018\u00018\n8\n2\u000e\u0010\u0016\u001a\n \u0012*\u0004\u0018\u00018\u000b8\u000b2\u000e\u0010\u0017\u001a\n \u0012*\u0004\u0018\u00018\f8\f2\u000e\u0010\u0018\u001a\n \u0012*\u0004\u0018\u00018\r8\r2\u000e\u0010\u0019\u001a\n \u0012*\u0004\u0018\u00018\u000e8\u000e2\u000e\u0010\u001a\u001a\n \u0012*\u0004\u0018\u00018\u000f8\u000fH\n¢\u0006\u0004\b\u001b\u0010\u001c"}, d2 = {"T1", "T2", "T3", "T4", "T5", "T6", "T7", "T8", "T9", "T10", "T11", "T12", "T13", "T14", "T15", "T16", "R", "Lcom/discord/utilities/rx/Holder;", "kotlin.jvm.PlatformType", "holder", "t10", "t11", "t12", "t13", "t14", "t15", "t16", NotificationCompat.CATEGORY_CALL, "(Lcom/discord/utilities/rx/Holder;Ljava/lang/Object;Ljava/lang/Object;Ljava/lang/Object;Ljava/lang/Object;Ljava/lang/Object;Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;", "<anonymous>"}, k = 3, mv = {1, 4, 2})
    /* renamed from: com.discord.utilities.rx.ObservableCombineLatestOverloadsKt$combineLatest$7, reason: invalid class name */
    public static final class AnonymousClass7<T1, T2, T3, T4, T5, T6, T7, T8, R, T10, T11, T12, T13, T14, T15, T16, T9> implements Func8<ObservableCombineLatestOverloads<T1, T2, T3, T4, T5, T6, T7, T8, T9>, T10, T11, T12, T13, T14, T15, T16, R> {
        public final /* synthetic */ Function16 $combineFunction;

        public AnonymousClass7(Function16 function16) {
            this.$combineFunction = function16;
        }

        public final R call(ObservableCombineLatestOverloads<T1, T2, T3, T4, T5, T6, T7, T8, T9> observableCombineLatestOverloads, T10 t10, T11 t11, T12 t12, T13 t13, T14 t14, T15 t15, T16 t16) {
            return (R) this.$combineFunction.invoke(observableCombineLatestOverloads.getT1(), observableCombineLatestOverloads.getT2(), observableCombineLatestOverloads.getT3(), observableCombineLatestOverloads.getT4(), observableCombineLatestOverloads.getT5(), observableCombineLatestOverloads.getT6(), observableCombineLatestOverloads.getT7(), observableCombineLatestOverloads.getT8(), observableCombineLatestOverloads.getT9(), t10, t11, t12, t13, t14, t15, t16);
        }

        /* JADX WARN: Multi-variable type inference failed */
        @Override // rx.functions.Func8
        public /* bridge */ /* synthetic */ Object call(Object obj, Object obj2, Object obj3, Object obj4, Object obj5, Object obj6, Object obj7, Object obj8) {
            return call((ObservableCombineLatestOverloads) obj, (ObservableCombineLatestOverloads<T1, T2, T3, T4, T5, T6, T7, T8, T9>) obj2, obj3, obj4, obj5, obj6, obj7, obj8);
        }
    }

    /* JADX INFO: Add missing generic type declarations: [T10, T12, T11, T14, T13, T16, T15, T17] */
    /* compiled from: ObservableCombineLatestOverloads.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\f\n\u0002\b\u0012\n\u0002\u0018\u0002\n\u0002\b\r\u0010\u001f\u001a\n \u0013*\u0004\u0018\u00018\u00118\u0011\"\u0004\b\u0000\u0010\u0000\"\u0004\b\u0001\u0010\u0001\"\u0004\b\u0002\u0010\u0002\"\u0004\b\u0003\u0010\u0003\"\u0004\b\u0004\u0010\u0004\"\u0004\b\u0005\u0010\u0005\"\u0004\b\u0006\u0010\u0006\"\u0004\b\u0007\u0010\u0007\"\u0004\b\b\u0010\b\"\u0004\b\t\u0010\t\"\u0004\b\n\u0010\n\"\u0004\b\u000b\u0010\u000b\"\u0004\b\f\u0010\f\"\u0004\b\r\u0010\r\"\u0004\b\u000e\u0010\u000e\"\u0004\b\u000f\u0010\u000f\"\u0004\b\u0010\u0010\u0010\"\u0004\b\u0011\u0010\u00112z\u0010\u0014\u001av\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u0001\u0012\u0004\u0012\u00028\u0002\u0012\u0004\u0012\u00028\u0003\u0012\u0004\u0012\u00028\u0004\u0012\u0004\u0012\u00028\u0005\u0012\u0004\u0012\u00028\u0006\u0012\u0004\u0012\u00028\u0007\u0012\u0004\u0012\u00028\b \u0013*:\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u0001\u0012\u0004\u0012\u00028\u0002\u0012\u0004\u0012\u00028\u0003\u0012\u0004\u0012\u00028\u0004\u0012\u0004\u0012\u00028\u0005\u0012\u0004\u0012\u00028\u0006\u0012\u0004\u0012\u00028\u0007\u0012\u0004\u0012\u00028\b\u0018\u00010\u00120\u00122\u000e\u0010\u0015\u001a\n \u0013*\u0004\u0018\u00018\t8\t2\u000e\u0010\u0016\u001a\n \u0013*\u0004\u0018\u00018\n8\n2\u000e\u0010\u0017\u001a\n \u0013*\u0004\u0018\u00018\u000b8\u000b2\u000e\u0010\u0018\u001a\n \u0013*\u0004\u0018\u00018\f8\f2\u000e\u0010\u0019\u001a\n \u0013*\u0004\u0018\u00018\r8\r2\u000e\u0010\u001a\u001a\n \u0013*\u0004\u0018\u00018\u000e8\u000e2\u000e\u0010\u001b\u001a\n \u0013*\u0004\u0018\u00018\u000f8\u000f2\u000e\u0010\u001c\u001a\n \u0013*\u0004\u0018\u00018\u00108\u0010H\n¢\u0006\u0004\b\u001d\u0010\u001e"}, d2 = {"T1", "T2", "T3", "T4", "T5", "T6", "T7", "T8", "T9", "T10", "T11", "T12", "T13", "T14", "T15", "T16", "T17", "R", "Lcom/discord/utilities/rx/Holder;", "kotlin.jvm.PlatformType", "holder", "t10", "t11", "t12", "t13", "t14", "t15", "t16", "t17", NotificationCompat.CATEGORY_CALL, "(Lcom/discord/utilities/rx/Holder;Ljava/lang/Object;Ljava/lang/Object;Ljava/lang/Object;Ljava/lang/Object;Ljava/lang/Object;Ljava/lang/Object;Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;", "<anonymous>"}, k = 3, mv = {1, 4, 2})
    /* renamed from: com.discord.utilities.rx.ObservableCombineLatestOverloadsKt$combineLatest$8, reason: invalid class name */
    public static final class AnonymousClass8<T1, T2, T3, T4, T5, T6, T7, T8, T9, R, T10, T11, T12, T13, T14, T15, T16, T17> implements Func9<ObservableCombineLatestOverloads<T1, T2, T3, T4, T5, T6, T7, T8, T9>, T10, T11, T12, T13, T14, T15, T16, T17, R> {
        public final /* synthetic */ Function17 $combineFunction;

        public AnonymousClass8(Function17 function17) {
            this.$combineFunction = function17;
        }

        public final R call(ObservableCombineLatestOverloads<T1, T2, T3, T4, T5, T6, T7, T8, T9> observableCombineLatestOverloads, T10 t10, T11 t11, T12 t12, T13 t13, T14 t14, T15 t15, T16 t16, T17 t17) {
            return (R) this.$combineFunction.invoke(observableCombineLatestOverloads.getT1(), observableCombineLatestOverloads.getT2(), observableCombineLatestOverloads.getT3(), observableCombineLatestOverloads.getT4(), observableCombineLatestOverloads.getT5(), observableCombineLatestOverloads.getT6(), observableCombineLatestOverloads.getT7(), observableCombineLatestOverloads.getT8(), observableCombineLatestOverloads.getT9(), t10, t11, t12, t13, t14, t15, t16, t17);
        }

        /* JADX WARN: Multi-variable type inference failed */
        @Override // rx.functions.Func9
        public /* bridge */ /* synthetic */ Object call(Object obj, Object obj2, Object obj3, Object obj4, Object obj5, Object obj6, Object obj7, Object obj8, Object obj9) {
            return call((ObservableCombineLatestOverloads) obj, (ObservableCombineLatestOverloads<T1, T2, T3, T4, T5, T6, T7, T8, T9>) obj2, obj3, obj4, obj5, obj6, obj7, obj8, obj9);
        }
    }

    /* JADX INFO: Add missing generic type declarations: [T7, T8, T9, T10, T21, T20, T12, T11, T22, T14, T13, T16, T15, T18, T17, T19] */
    /* compiled from: ObservableCombineLatestOverloads.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\f\n\u0002\b\u0017\n\u0002\u0018\u0002\n\u0002\b\n\u0010!\u001a\n \u0018*\u0004\u0018\u00018\u00168\u0016\"\u0004\b\u0000\u0010\u0000\"\u0004\b\u0001\u0010\u0001\"\u0004\b\u0002\u0010\u0002\"\u0004\b\u0003\u0010\u0003\"\u0004\b\u0004\u0010\u0004\"\u0004\b\u0005\u0010\u0005\"\u0004\b\u0006\u0010\u0006\"\u0004\b\u0007\u0010\u0007\"\u0004\b\b\u0010\b\"\u0004\b\t\u0010\t\"\u0004\b\n\u0010\n\"\u0004\b\u000b\u0010\u000b\"\u0004\b\f\u0010\f\"\u0004\b\r\u0010\r\"\u0004\b\u000e\u0010\u000e\"\u0004\b\u000f\u0010\u000f\"\u0004\b\u0010\u0010\u0010\"\u0004\b\u0011\u0010\u0011\"\u0004\b\u0012\u0010\u0012\"\u0004\b\u0013\u0010\u0013\"\u0004\b\u0014\u0010\u0014\"\u0004\b\u0015\u0010\u0015\"\u0004\b\u0016\u0010\u00162z\u0010\u0019\u001av\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u0001\u0012\u0004\u0012\u00028\u0002\u0012\u0004\u0012\u00028\u0003\u0012\u0004\u0012\u00028\u0004\u0012\u0004\u0012\u00028\u0005\u0012\u0004\u0012\u00028\u0006\u0012\u0004\u0012\u00028\u0007\u0012\u0004\u0012\u00028\b \u0018*:\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u0001\u0012\u0004\u0012\u00028\u0002\u0012\u0004\u0012\u00028\u0003\u0012\u0004\u0012\u00028\u0004\u0012\u0004\u0012\u00028\u0005\u0012\u0004\u0012\u00028\u0006\u0012\u0004\u0012\u00028\u0007\u0012\u0004\u0012\u00028\b\u0018\u00010\u00170\u00172z\u0010\u001a\u001av\u0012\u0004\u0012\u00028\t\u0012\u0004\u0012\u00028\n\u0012\u0004\u0012\u00028\u000b\u0012\u0004\u0012\u00028\f\u0012\u0004\u0012\u00028\r\u0012\u0004\u0012\u00028\u000e\u0012\u0004\u0012\u00028\u000f\u0012\u0004\u0012\u00028\u0010\u0012\u0004\u0012\u00028\u0011 \u0018*:\u0012\u0004\u0012\u00028\t\u0012\u0004\u0012\u00028\n\u0012\u0004\u0012\u00028\u000b\u0012\u0004\u0012\u00028\f\u0012\u0004\u0012\u00028\r\u0012\u0004\u0012\u00028\u000e\u0012\u0004\u0012\u00028\u000f\u0012\u0004\u0012\u00028\u0010\u0012\u0004\u0012\u00028\u0011\u0018\u00010\u00170\u00172\u000e\u0010\u001b\u001a\n \u0018*\u0004\u0018\u00018\u00128\u00122\u000e\u0010\u001c\u001a\n \u0018*\u0004\u0018\u00018\u00138\u00132\u000e\u0010\u001d\u001a\n \u0018*\u0004\u0018\u00018\u00148\u00142\u000e\u0010\u001e\u001a\n \u0018*\u0004\u0018\u00018\u00158\u0015H\n¢\u0006\u0004\b\u001f\u0010 "}, d2 = {"T1", "T2", "T3", "T4", "T5", "T6", "T7", "T8", "T9", "T10", "T11", "T12", "T13", "T14", "T15", "T16", "T17", "T18", "T19", "T20", "T21", "T22", "R", "Lcom/discord/utilities/rx/Holder;", "kotlin.jvm.PlatformType", "holder", "holder2", "o19", "o20", "o21", "o22", NotificationCompat.CATEGORY_CALL, "(Lcom/discord/utilities/rx/Holder;Lcom/discord/utilities/rx/Holder;Ljava/lang/Object;Ljava/lang/Object;Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;", "<anonymous>"}, k = 3, mv = {1, 4, 2})
    /* renamed from: com.discord.utilities.rx.ObservableCombineLatestOverloadsKt$combineLatest$9, reason: invalid class name */
    public static final class AnonymousClass9<T1, T2, T3, T4, T5, T6, R, T10, T11, T12, T13, T14, T15, T16, T17, T18, T19, T20, T21, T22, T7, T8, T9> implements Func6<ObservableCombineLatestOverloads<T1, T2, T3, T4, T5, T6, T7, T8, T9>, ObservableCombineLatestOverloads<T10, T11, T12, T13, T14, T15, T16, T17, T18>, T19, T20, T21, T22, R> {
        public final /* synthetic */ Function22 $combineFunction;

        public AnonymousClass9(Function22 function22) {
            this.$combineFunction = function22;
        }

        public final R call(ObservableCombineLatestOverloads<T1, T2, T3, T4, T5, T6, T7, T8, T9> observableCombineLatestOverloads, ObservableCombineLatestOverloads<T10, T11, T12, T13, T14, T15, T16, T17, T18> observableCombineLatestOverloads2, T19 t19, T20 t20, T21 t21, T22 t22) {
            return (R) this.$combineFunction.invoke(observableCombineLatestOverloads.getT1(), observableCombineLatestOverloads.getT2(), observableCombineLatestOverloads.getT3(), observableCombineLatestOverloads.getT4(), observableCombineLatestOverloads.getT5(), observableCombineLatestOverloads.getT6(), observableCombineLatestOverloads.getT7(), observableCombineLatestOverloads.getT8(), observableCombineLatestOverloads.getT9(), observableCombineLatestOverloads2.getT1(), observableCombineLatestOverloads2.getT2(), observableCombineLatestOverloads2.getT3(), observableCombineLatestOverloads2.getT4(), observableCombineLatestOverloads2.getT5(), observableCombineLatestOverloads2.getT6(), observableCombineLatestOverloads2.getT7(), observableCombineLatestOverloads2.getT8(), observableCombineLatestOverloads2.getT9(), t19, t20, t21, t22);
        }

        /* JADX WARN: Multi-variable type inference failed */
        @Override // rx.functions.Func6
        public /* bridge */ /* synthetic */ Object call(Object obj, Object obj2, Object obj3, Object obj4, Object obj5, Object obj6) {
            return call((ObservableCombineLatestOverloads) obj, (ObservableCombineLatestOverloads) obj2, (ObservableCombineLatestOverloads<T10, T11, T12, T13, T14, T15, T16, T17, T18>) obj3, obj4, obj5, obj6);
        }
    }

    /* compiled from: ObservableCombineLatestOverloads.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\f\n\u0002\b\u0013\n\u0002\u0018\u0002\n\u0002\b\u0003\u0010\u0016\u001av\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u0001\u0012\u0004\u0012\u00028\u0002\u0012\u0004\u0012\u00028\u0003\u0012\u0004\u0012\u00028\u0004\u0012\u0004\u0012\u00028\u0005\u0012\u0004\u0012\u00028\u0006\u0012\u0004\u0012\u00028\u0007\u0012\u0004\u0012\u00028\b \t*:\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u0001\u0012\u0004\u0012\u00028\u0002\u0012\u0004\u0012\u00028\u0003\u0012\u0004\u0012\u00028\u0004\u0012\u0004\u0012\u00028\u0005\u0012\u0004\u0012\u00028\u0006\u0012\u0004\u0012\u00028\u0007\u0012\u0004\u0012\u00028\b\u0018\u00010\u00130\u0013\"\u0004\b\u0000\u0010\u0000\"\u0004\b\u0001\u0010\u0001\"\u0004\b\u0002\u0010\u0002\"\u0004\b\u0003\u0010\u0003\"\u0004\b\u0004\u0010\u0004\"\u0004\b\u0005\u0010\u0005\"\u0004\b\u0006\u0010\u0006\"\u0004\b\u0007\u0010\u0007\"\u0004\b\b\u0010\b2\u000e\u0010\n\u001a\n \t*\u0004\u0018\u00018\u00008\u00002\u000e\u0010\u000b\u001a\n \t*\u0004\u0018\u00018\u00018\u00012\u000e\u0010\f\u001a\n \t*\u0004\u0018\u00018\u00028\u00022\u000e\u0010\r\u001a\n \t*\u0004\u0018\u00018\u00038\u00032\u000e\u0010\u000e\u001a\n \t*\u0004\u0018\u00018\u00048\u00042\u000e\u0010\u000f\u001a\n \t*\u0004\u0018\u00018\u00058\u00052\u000e\u0010\u0010\u001a\n \t*\u0004\u0018\u00018\u00068\u00062\u000e\u0010\u0011\u001a\n \t*\u0004\u0018\u00018\u00078\u00072\u000e\u0010\u0012\u001a\n \t*\u0004\u0018\u00018\b8\bH\n¢\u0006\u0004\b\u0014\u0010\u0015"}, d2 = {"T1", "T2", "T3", "T4", "T5", "T6", "T7", "T8", "T9", "kotlin.jvm.PlatformType", "t1", "t2", "t3", "t4", "t5", "t6", "t7", "t8", "t9", "Lcom/discord/utilities/rx/Holder;", NotificationCompat.CATEGORY_CALL, "(Ljava/lang/Object;Ljava/lang/Object;Ljava/lang/Object;Ljava/lang/Object;Ljava/lang/Object;Ljava/lang/Object;Ljava/lang/Object;Ljava/lang/Object;Ljava/lang/Object;)Lcom/discord/utilities/rx/Holder;", "<anonymous>"}, k = 3, mv = {1, 4, 2})
    /* renamed from: com.discord.utilities.rx.ObservableCombineLatestOverloadsKt$createHolderObservable$1, reason: invalid class name */
    public static final class AnonymousClass1<T1, T2, T3, T4, T5, T6, T7, T8, T9, R> implements Func9<T1, T2, T3, T4, T5, T6, T7, T8, T9, ObservableCombineLatestOverloads<T1, T2, T3, T4, T5, T6, T7, T8, T9>> {
        public static final AnonymousClass1 INSTANCE = new AnonymousClass1();

        @Override // rx.functions.Func9
        public final ObservableCombineLatestOverloads<T1, T2, T3, T4, T5, T6, T7, T8, T9> call(T1 t1, T2 t2, T3 t3, T4 t4, T5 t5, T6 t6, T7 t7, T8 t8, T9 t9) {
            return new ObservableCombineLatestOverloads<>(t1, t2, t3, t4, t5, t6, t7, t8, t9);
        }

        /* JADX WARN: Multi-variable type inference failed */
        @Override // rx.functions.Func9
        public /* bridge */ /* synthetic */ Object call(Object obj, Object obj2, Object obj3, Object obj4, Object obj5, Object obj6, Object obj7, Object obj8, Object obj9) {
            return call((AnonymousClass1<T1, T2, T3, T4, T5, T6, T7, T8, T9, R>) obj, obj2, obj3, obj4, obj5, obj6, obj7, obj8, obj9);
        }
    }

    public static final <T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, R> Observable<R> combineLatest(Observable<T1> observable, Observable<T2> observable2, Observable<T3> observable3, Observable<T4> observable4, Observable<T5> observable5, Observable<T6> observable6, Observable<T7> observable7, Observable<T8> observable8, Observable<T9> observable9, Observable<T10> observable10, Function10<? super T1, ? super T2, ? super T3, ? super T4, ? super T5, ? super T6, ? super T7, ? super T8, ? super T9, ? super T10, ? extends R> function10) {
        Intrinsics3.checkNotNullParameter(observable, "o1");
        Intrinsics3.checkNotNullParameter(observable2, "o2");
        Intrinsics3.checkNotNullParameter(observable3, "o3");
        Intrinsics3.checkNotNullParameter(observable4, "o4");
        Intrinsics3.checkNotNullParameter(observable5, "o5");
        Intrinsics3.checkNotNullParameter(observable6, "o6");
        Intrinsics3.checkNotNullParameter(observable7, "o7");
        Intrinsics3.checkNotNullParameter(observable8, "o8");
        Intrinsics3.checkNotNullParameter(observable9, "o9");
        Intrinsics3.checkNotNullParameter(observable10, "o10");
        Intrinsics3.checkNotNullParameter(function10, "combineFunction");
        Observable<R> observableJ = Observable.j(createHolderObservable(observable, observable2, observable3, observable4, observable5, observable6, observable7, observable8, observable9), observable10, new AnonymousClass1(function10));
        Intrinsics3.checkNotNullExpressionValue(observableJ, "Observable\n        .comb…t10\n          )\n        }");
        return observableJ;
    }

    private static final <T1, T2, T3, T4, T5, T6, T7, T8, T9> Observable<ObservableCombineLatestOverloads<T1, T2, T3, T4, T5, T6, T7, T8, T9>> createHolderObservable(Observable<T1> observable, Observable<T2> observable2, Observable<T3> observable3, Observable<T4> observable4, Observable<T5> observable5, Observable<T6> observable6, Observable<T7> observable7, Observable<T8> observable8, Observable<T9> observable9) {
        Observable<ObservableCombineLatestOverloads<T1, T2, T3, T4, T5, T6, T7, T8, T9>> observableC = Observable.c(observable, observable2, observable3, observable4, observable5, observable6, observable7, observable8, observable9, AnonymousClass1.INSTANCE);
        Intrinsics3.checkNotNullExpressionValue(observableC, "Observable\n    .combineL…t5, t6, t7, t8, t9)\n    }");
        return observableC;
    }

    public static final <T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11, R> Observable<R> combineLatest(Observable<T1> observable, Observable<T2> observable2, Observable<T3> observable3, Observable<T4> observable4, Observable<T5> observable5, Observable<T6> observable6, Observable<T7> observable7, Observable<T8> observable8, Observable<T9> observable9, Observable<T10> observable10, Observable<T11> observable11, Function11<? super T1, ? super T2, ? super T3, ? super T4, ? super T5, ? super T6, ? super T7, ? super T8, ? super T9, ? super T10, ? super T11, ? extends R> function11) {
        Intrinsics3.checkNotNullParameter(observable, "o1");
        Intrinsics3.checkNotNullParameter(observable2, "o2");
        Intrinsics3.checkNotNullParameter(observable3, "o3");
        Intrinsics3.checkNotNullParameter(observable4, "o4");
        Intrinsics3.checkNotNullParameter(observable5, "o5");
        Intrinsics3.checkNotNullParameter(observable6, "o6");
        Intrinsics3.checkNotNullParameter(observable7, "o7");
        Intrinsics3.checkNotNullParameter(observable8, "o8");
        Intrinsics3.checkNotNullParameter(observable9, "o9");
        Intrinsics3.checkNotNullParameter(observable10, "o10");
        Intrinsics3.checkNotNullParameter(observable11, "o11");
        Intrinsics3.checkNotNullParameter(function11, "combineFunction");
        Observable<R> observableI = Observable.i(createHolderObservable(observable, observable2, observable3, observable4, observable5, observable6, observable7, observable8, observable9), observable10, observable11, new AnonymousClass2(function11));
        Intrinsics3.checkNotNullExpressionValue(observableI, "Observable\n        .comb…t11\n          )\n        }");
        return observableI;
    }

    public static final <T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11, T12, R> Observable<R> combineLatest(Observable<T1> observable, Observable<T2> observable2, Observable<T3> observable3, Observable<T4> observable4, Observable<T5> observable5, Observable<T6> observable6, Observable<T7> observable7, Observable<T8> observable8, Observable<T9> observable9, Observable<T10> observable10, Observable<T11> observable11, Observable<T12> observable12, Function12<? super T1, ? super T2, ? super T3, ? super T4, ? super T5, ? super T6, ? super T7, ? super T8, ? super T9, ? super T10, ? super T11, ? super T12, ? extends R> function12) {
        Intrinsics3.checkNotNullParameter(observable, "o1");
        Intrinsics3.checkNotNullParameter(observable2, "o2");
        Intrinsics3.checkNotNullParameter(observable3, "o3");
        Intrinsics3.checkNotNullParameter(observable4, "o4");
        Intrinsics3.checkNotNullParameter(observable5, "o5");
        Intrinsics3.checkNotNullParameter(observable6, "o6");
        Intrinsics3.checkNotNullParameter(observable7, "o7");
        Intrinsics3.checkNotNullParameter(observable8, "o8");
        Intrinsics3.checkNotNullParameter(observable9, "o9");
        Intrinsics3.checkNotNullParameter(observable10, "o10");
        Intrinsics3.checkNotNullParameter(observable11, "o11");
        Intrinsics3.checkNotNullParameter(observable12, "o12");
        Intrinsics3.checkNotNullParameter(function12, "combineFunction");
        Observable<R> observableH = Observable.h(createHolderObservable(observable, observable2, observable3, observable4, observable5, observable6, observable7, observable8, observable9), observable10, observable11, observable12, new AnonymousClass3(function12));
        Intrinsics3.checkNotNullExpressionValue(observableH, "Observable\n        .comb…t12\n          )\n        }");
        return observableH;
    }

    public static final <T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11, T12, T13, R> Observable<R> combineLatest(Observable<T1> observable, Observable<T2> observable2, Observable<T3> observable3, Observable<T4> observable4, Observable<T5> observable5, Observable<T6> observable6, Observable<T7> observable7, Observable<T8> observable8, Observable<T9> observable9, Observable<T10> observable10, Observable<T11> observable11, Observable<T12> observable12, Observable<T13> observable13, Function13<? super T1, ? super T2, ? super T3, ? super T4, ? super T5, ? super T6, ? super T7, ? super T8, ? super T9, ? super T10, ? super T11, ? super T12, ? super T13, ? extends R> function13) {
        Intrinsics3.checkNotNullParameter(observable, "o1");
        Intrinsics3.checkNotNullParameter(observable2, "o2");
        Intrinsics3.checkNotNullParameter(observable3, "o3");
        Intrinsics3.checkNotNullParameter(observable4, "o4");
        Intrinsics3.checkNotNullParameter(observable5, "o5");
        Intrinsics3.checkNotNullParameter(observable6, "o6");
        Intrinsics3.checkNotNullParameter(observable7, "o7");
        Intrinsics3.checkNotNullParameter(observable8, "o8");
        Intrinsics3.checkNotNullParameter(observable9, "o9");
        Intrinsics3.checkNotNullParameter(observable10, "o10");
        Intrinsics3.checkNotNullParameter(observable11, "o11");
        Intrinsics3.checkNotNullParameter(observable12, "o12");
        Intrinsics3.checkNotNullParameter(observable13, "o13");
        Intrinsics3.checkNotNullParameter(function13, "combineFunction");
        Observable<R> observableG = Observable.g(createHolderObservable(observable, observable2, observable3, observable4, observable5, observable6, observable7, observable8, observable9), observable10, observable11, observable12, observable13, new AnonymousClass4(function13));
        Intrinsics3.checkNotNullExpressionValue(observableG, "Observable\n        .comb…t13\n          )\n        }");
        return observableG;
    }

    public static final <T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11, T12, T13, T14, R> Observable<R> combineLatest(Observable<T1> observable, Observable<T2> observable2, Observable<T3> observable3, Observable<T4> observable4, Observable<T5> observable5, Observable<T6> observable6, Observable<T7> observable7, Observable<T8> observable8, Observable<T9> observable9, Observable<T10> observable10, Observable<T11> observable11, Observable<T12> observable12, Observable<T13> observable13, Observable<T14> observable14, Function14<? super T1, ? super T2, ? super T3, ? super T4, ? super T5, ? super T6, ? super T7, ? super T8, ? super T9, ? super T10, ? super T11, ? super T12, ? super T13, ? super T14, ? extends R> function14) {
        Intrinsics3.checkNotNullParameter(observable, "o1");
        Intrinsics3.checkNotNullParameter(observable2, "o2");
        Intrinsics3.checkNotNullParameter(observable3, "o3");
        Intrinsics3.checkNotNullParameter(observable4, "o4");
        Intrinsics3.checkNotNullParameter(observable5, "o5");
        Intrinsics3.checkNotNullParameter(observable6, "o6");
        Intrinsics3.checkNotNullParameter(observable7, "o7");
        Intrinsics3.checkNotNullParameter(observable8, "o8");
        Intrinsics3.checkNotNullParameter(observable9, "o9");
        Intrinsics3.checkNotNullParameter(observable10, "o10");
        Intrinsics3.checkNotNullParameter(observable11, "o11");
        Intrinsics3.checkNotNullParameter(observable12, "o12");
        Intrinsics3.checkNotNullParameter(observable13, "o13");
        Intrinsics3.checkNotNullParameter(observable14, "o14");
        Intrinsics3.checkNotNullParameter(function14, "combineFunction");
        Observable<R> observableF = Observable.f(createHolderObservable(observable, observable2, observable3, observable4, observable5, observable6, observable7, observable8, observable9), observable10, observable11, observable12, observable13, observable14, new AnonymousClass5(function14));
        Intrinsics3.checkNotNullExpressionValue(observableF, "Observable\n        .comb…t14\n          )\n        }");
        return observableF;
    }

    public static final <T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11, T12, T13, T14, T15, R> Observable<R> combineLatest(Observable<T1> observable, Observable<T2> observable2, Observable<T3> observable3, Observable<T4> observable4, Observable<T5> observable5, Observable<T6> observable6, Observable<T7> observable7, Observable<T8> observable8, Observable<T9> observable9, Observable<T10> observable10, Observable<T11> observable11, Observable<T12> observable12, Observable<T13> observable13, Observable<T14> observable14, Observable<T15> observable15, Function15<? super T1, ? super T2, ? super T3, ? super T4, ? super T5, ? super T6, ? super T7, ? super T8, ? super T9, ? super T10, ? super T11, ? super T12, ? super T13, ? super T14, ? super T15, ? extends R> function15) {
        Intrinsics3.checkNotNullParameter(observable, "o1");
        Intrinsics3.checkNotNullParameter(observable2, "o2");
        Intrinsics3.checkNotNullParameter(observable3, "o3");
        Intrinsics3.checkNotNullParameter(observable4, "o4");
        Intrinsics3.checkNotNullParameter(observable5, "o5");
        Intrinsics3.checkNotNullParameter(observable6, "o6");
        Intrinsics3.checkNotNullParameter(observable7, "o7");
        Intrinsics3.checkNotNullParameter(observable8, "o8");
        Intrinsics3.checkNotNullParameter(observable9, "o9");
        Intrinsics3.checkNotNullParameter(observable10, "o10");
        Intrinsics3.checkNotNullParameter(observable11, "o11");
        Intrinsics3.checkNotNullParameter(observable12, "o12");
        Intrinsics3.checkNotNullParameter(observable13, "o13");
        Intrinsics3.checkNotNullParameter(observable14, "o14");
        Intrinsics3.checkNotNullParameter(observable15, "o15");
        Intrinsics3.checkNotNullParameter(function15, "combineFunction");
        Observable<R> observableE = Observable.e(createHolderObservable(observable, observable2, observable3, observable4, observable5, observable6, observable7, observable8, observable9), observable10, observable11, observable12, observable13, observable14, observable15, new AnonymousClass6(function15));
        Intrinsics3.checkNotNullExpressionValue(observableE, "Observable\n        .comb…t15\n          )\n        }");
        return observableE;
    }

    public static final <T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11, T12, T13, T14, T15, T16, R> Observable<R> combineLatest(Observable<T1> observable, Observable<T2> observable2, Observable<T3> observable3, Observable<T4> observable4, Observable<T5> observable5, Observable<T6> observable6, Observable<T7> observable7, Observable<T8> observable8, Observable<T9> observable9, Observable<T10> observable10, Observable<T11> observable11, Observable<T12> observable12, Observable<T13> observable13, Observable<T14> observable14, Observable<T15> observable15, Observable<T16> observable16, Function16<? super T1, ? super T2, ? super T3, ? super T4, ? super T5, ? super T6, ? super T7, ? super T8, ? super T9, ? super T10, ? super T11, ? super T12, ? super T13, ? super T14, ? super T15, ? super T16, ? extends R> function16) {
        Intrinsics3.checkNotNullParameter(observable, "o1");
        Intrinsics3.checkNotNullParameter(observable2, "o2");
        Intrinsics3.checkNotNullParameter(observable3, "o3");
        Intrinsics3.checkNotNullParameter(observable4, "o4");
        Intrinsics3.checkNotNullParameter(observable5, "o5");
        Intrinsics3.checkNotNullParameter(observable6, "o6");
        Intrinsics3.checkNotNullParameter(observable7, "o7");
        Intrinsics3.checkNotNullParameter(observable8, "o8");
        Intrinsics3.checkNotNullParameter(observable9, "o9");
        Intrinsics3.checkNotNullParameter(observable10, "o10");
        Intrinsics3.checkNotNullParameter(observable11, "o11");
        Intrinsics3.checkNotNullParameter(observable12, "o12");
        Intrinsics3.checkNotNullParameter(observable13, "o13");
        Intrinsics3.checkNotNullParameter(observable14, "o14");
        Intrinsics3.checkNotNullParameter(observable15, "o15");
        Intrinsics3.checkNotNullParameter(observable16, "o16");
        Intrinsics3.checkNotNullParameter(function16, "combineFunction");
        Observable<R> observableD = Observable.d(createHolderObservable(observable, observable2, observable3, observable4, observable5, observable6, observable7, observable8, observable9), observable10, observable11, observable12, observable13, observable14, observable15, observable16, new AnonymousClass7(function16));
        Intrinsics3.checkNotNullExpressionValue(observableD, "Observable\n        .comb…t16\n          )\n        }");
        return observableD;
    }

    public static final <T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11, T12, T13, T14, T15, T16, T17, R> Observable<R> combineLatest(Observable<T1> observable, Observable<T2> observable2, Observable<T3> observable3, Observable<T4> observable4, Observable<T5> observable5, Observable<T6> observable6, Observable<T7> observable7, Observable<T8> observable8, Observable<T9> observable9, Observable<T10> observable10, Observable<T11> observable11, Observable<T12> observable12, Observable<T13> observable13, Observable<T14> observable14, Observable<T15> observable15, Observable<T16> observable16, Observable<T17> observable17, Function17<? super T1, ? super T2, ? super T3, ? super T4, ? super T5, ? super T6, ? super T7, ? super T8, ? super T9, ? super T10, ? super T11, ? super T12, ? super T13, ? super T14, ? super T15, ? super T16, ? super T17, ? extends R> function17) {
        Intrinsics3.checkNotNullParameter(observable, "o1");
        Intrinsics3.checkNotNullParameter(observable2, "o2");
        Intrinsics3.checkNotNullParameter(observable3, "o3");
        Intrinsics3.checkNotNullParameter(observable4, "o4");
        Intrinsics3.checkNotNullParameter(observable5, "o5");
        Intrinsics3.checkNotNullParameter(observable6, "o6");
        Intrinsics3.checkNotNullParameter(observable7, "o7");
        Intrinsics3.checkNotNullParameter(observable8, "o8");
        Intrinsics3.checkNotNullParameter(observable9, "o9");
        Intrinsics3.checkNotNullParameter(observable10, "o10");
        Intrinsics3.checkNotNullParameter(observable11, "o11");
        Intrinsics3.checkNotNullParameter(observable12, "o12");
        Intrinsics3.checkNotNullParameter(observable13, "o13");
        Intrinsics3.checkNotNullParameter(observable14, "o14");
        Intrinsics3.checkNotNullParameter(observable15, "o15");
        Intrinsics3.checkNotNullParameter(observable16, "o16");
        Intrinsics3.checkNotNullParameter(observable17, "o17");
        Intrinsics3.checkNotNullParameter(function17, "combineFunction");
        Observable<R> observableC = Observable.c(createHolderObservable(observable, observable2, observable3, observable4, observable5, observable6, observable7, observable8, observable9), observable10, observable11, observable12, observable13, observable14, observable15, observable16, observable17, new AnonymousClass8(function17));
        Intrinsics3.checkNotNullExpressionValue(observableC, "Observable\n        .comb…t17\n          )\n        }");
        return observableC;
    }

    public static final <T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11, T12, T13, T14, T15, T16, T17, T18, T19, T20, T21, T22, R> Observable<R> combineLatest(Observable<T1> observable, Observable<T2> observable2, Observable<T3> observable3, Observable<T4> observable4, Observable<T5> observable5, Observable<T6> observable6, Observable<T7> observable7, Observable<T8> observable8, Observable<T9> observable9, Observable<T10> observable10, Observable<T11> observable11, Observable<T12> observable12, Observable<T13> observable13, Observable<T14> observable14, Observable<T15> observable15, Observable<T16> observable16, Observable<T17> observable17, Observable<T18> observable18, Observable<T19> observable19, Observable<T20> observable20, Observable<T21> observable21, Observable<T22> observable22, Function22<? super T1, ? super T2, ? super T3, ? super T4, ? super T5, ? super T6, ? super T7, ? super T8, ? super T9, ? super T10, ? super T11, ? super T12, ? super T13, ? super T14, ? super T15, ? super T16, ? super T17, ? super T18, ? super T19, ? super T20, ? super T21, ? super T22, ? extends R> function22) {
        Intrinsics3.checkNotNullParameter(observable, "o1");
        Intrinsics3.checkNotNullParameter(observable2, "o2");
        Intrinsics3.checkNotNullParameter(observable3, "o3");
        Intrinsics3.checkNotNullParameter(observable4, "o4");
        Intrinsics3.checkNotNullParameter(observable5, "o5");
        Intrinsics3.checkNotNullParameter(observable6, "o6");
        Intrinsics3.checkNotNullParameter(observable7, "o7");
        Intrinsics3.checkNotNullParameter(observable8, "o8");
        Intrinsics3.checkNotNullParameter(observable9, "o9");
        Intrinsics3.checkNotNullParameter(observable10, "o10");
        Intrinsics3.checkNotNullParameter(observable11, "o11");
        Intrinsics3.checkNotNullParameter(observable12, "o12");
        Intrinsics3.checkNotNullParameter(observable13, "o13");
        Intrinsics3.checkNotNullParameter(observable14, "o14");
        Intrinsics3.checkNotNullParameter(observable15, "o15");
        Intrinsics3.checkNotNullParameter(observable16, "o16");
        Intrinsics3.checkNotNullParameter(observable17, "o17");
        Intrinsics3.checkNotNullParameter(observable18, "o18");
        Intrinsics3.checkNotNullParameter(observable19, "o19");
        Intrinsics3.checkNotNullParameter(observable20, "o20");
        Intrinsics3.checkNotNullParameter(observable21, "o21");
        Intrinsics3.checkNotNullParameter(observable22, "o22");
        Intrinsics3.checkNotNullParameter(function22, "combineFunction");
        Observable<R> observableF = Observable.f(createHolderObservable(observable, observable2, observable3, observable4, observable5, observable6, observable7, observable8, observable9), createHolderObservable(observable10, observable11, observable12, observable13, observable14, observable15, observable16, observable17, observable18), observable19, observable20, observable21, observable22, new AnonymousClass9(function22));
        Intrinsics3.checkNotNullExpressionValue(observableF, "Observable\n        .comb…22,\n          )\n        }");
        return observableF;
    }
}
