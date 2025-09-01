package b.i.a.c.e3;

import android.content.Context;
import android.os.Handler;
import android.telephony.TelephonyManager;
import android.text.TextUtils;
import androidx.annotation.Nullable;
import b.c.a.a0.AnimatableValueParser;
import b.i.a.c.e3.BandwidthMeter;
import b.i.a.c.f3.Clock4;
import b.i.a.c.f3.NetworkTypeObserver;
import b.i.a.c.f3.Util2;
import b.i.b.b.ImmutableList2;
import b.i.b.b.ImmutableMap2;
import com.discord.api.permission.Permission;
import com.discord.stores.StoreGuildScheduledEvents;
import com.discord.widgets.chat.input.MentionUtils;
import com.google.android.material.behavior.HideBottomViewOnScrollBehavior;
import java.lang.ref.WeakReference;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Locale;
import java.util.Map;
import java.util.Objects;
import org.objectweb.asm.Opcodes;

/* compiled from: DefaultBandwidthMeter.java */
/* renamed from: b.i.a.c.e3.p, reason: use source file name */
/* loaded from: classes3.dex */
public final class DefaultBandwidthMeter implements BandwidthMeter, TransferListener {
    public static final ImmutableList2<Long> a = ImmutableList2.v(5400000L, 3300000L, 2000000L, 1300000L, 760000L);

    /* renamed from: b, reason: collision with root package name */
    public static final ImmutableList2<Long> f945b = ImmutableList2.v(1700000L, 820000L, 450000L, 180000L, 130000L);
    public static final ImmutableList2<Long> c = ImmutableList2.v(2300000L, 1300000L, 1000000L, 820000L, 570000L);
    public static final ImmutableList2<Long> d = ImmutableList2.v(3400000L, 2000000L, 1400000L, 1000000L, 620000L);
    public static final ImmutableList2<Long> e = ImmutableList2.v(7500000L, 5200000L, 3700000L, Long.valueOf(StoreGuildScheduledEvents.FETCH_GUILD_EVENTS_THRESHOLD), 1100000L);
    public static final ImmutableList2<Long> f = ImmutableList2.v(3300000L, 1900000L, 1700000L, 1500000L, 1200000L);

    @Nullable
    public static DefaultBandwidthMeter g;
    public final ImmutableMap2<Integer, Long> h;
    public final BandwidthMeter.a.C0029a i = new BandwidthMeter.a.C0029a();
    public final SlidingPercentile j;
    public final Clock4 k;
    public final boolean l;
    public int m;
    public long n;
    public long o;
    public int p;
    public long q;
    public long r;

    /* renamed from: s, reason: collision with root package name */
    public long f946s;
    public long t;

    /* compiled from: DefaultBandwidthMeter.java */
    /* renamed from: b.i.a.c.e3.p$b */
    public static final class b {

        @Nullable
        public final Context a;

        /* renamed from: b, reason: collision with root package name */
        public Map<Integer, Long> f947b;
        public int c;
        public Clock4 d;
        public boolean e;

        /* JADX WARN: Failed to restore switch over string. Please report as a decompilation issue */
        /* JADX WARN: Removed duplicated region for block: B:13:0x002e  */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
        */
        public b(Context context) {
            String strW1;
            int[] iArr;
            TelephonyManager telephonyManager;
            this.a = context == null ? null : context.getApplicationContext();
            int i = Util2.a;
            if (context == null || (telephonyManager = (TelephonyManager) context.getSystemService("phone")) == null) {
                strW1 = b.i.a.f.e.o.f.w1(Locale.getDefault().getCountry());
            } else {
                String networkCountryIso = telephonyManager.getNetworkCountryIso();
                if (!TextUtils.isEmpty(networkCountryIso)) {
                    strW1 = b.i.a.f.e.o.f.w1(networkCountryIso);
                }
            }
            ImmutableList2<Long> immutableList2 = DefaultBandwidthMeter.a;
            strW1.hashCode();
            char c = 65535;
            switch (strW1.hashCode()) {
                case 2083:
                    if (strW1.equals("AD")) {
                        c = 0;
                        break;
                    }
                    break;
                case 2084:
                    if (strW1.equals("AE")) {
                        c = 1;
                        break;
                    }
                    break;
                case 2085:
                    if (strW1.equals("AF")) {
                        c = 2;
                        break;
                    }
                    break;
                case 2086:
                    if (strW1.equals("AG")) {
                        c = 3;
                        break;
                    }
                    break;
                case 2088:
                    if (strW1.equals("AI")) {
                        c = 4;
                        break;
                    }
                    break;
                case 2091:
                    if (strW1.equals("AL")) {
                        c = 5;
                        break;
                    }
                    break;
                case 2092:
                    if (strW1.equals("AM")) {
                        c = 6;
                        break;
                    }
                    break;
                case 2094:
                    if (strW1.equals("AO")) {
                        c = 7;
                        break;
                    }
                    break;
                case 2096:
                    if (strW1.equals("AQ")) {
                        c = '\b';
                        break;
                    }
                    break;
                case 2097:
                    if (strW1.equals("AR")) {
                        c = '\t';
                        break;
                    }
                    break;
                case 2098:
                    if (strW1.equals("AS")) {
                        c = '\n';
                        break;
                    }
                    break;
                case 2099:
                    if (strW1.equals("AT")) {
                        c = 11;
                        break;
                    }
                    break;
                case 2100:
                    if (strW1.equals("AU")) {
                        c = '\f';
                        break;
                    }
                    break;
                case 2102:
                    if (strW1.equals("AW")) {
                        c = '\r';
                        break;
                    }
                    break;
                case 2103:
                    if (strW1.equals("AX")) {
                        c = 14;
                        break;
                    }
                    break;
                case 2105:
                    if (strW1.equals("AZ")) {
                        c = 15;
                        break;
                    }
                    break;
                case 2111:
                    if (strW1.equals("BA")) {
                        c = 16;
                        break;
                    }
                    break;
                case 2112:
                    if (strW1.equals("BB")) {
                        c = 17;
                        break;
                    }
                    break;
                case 2114:
                    if (strW1.equals("BD")) {
                        c = 18;
                        break;
                    }
                    break;
                case 2115:
                    if (strW1.equals("BE")) {
                        c = 19;
                        break;
                    }
                    break;
                case 2116:
                    if (strW1.equals("BF")) {
                        c = 20;
                        break;
                    }
                    break;
                case 2117:
                    if (strW1.equals("BG")) {
                        c = 21;
                        break;
                    }
                    break;
                case 2118:
                    if (strW1.equals("BH")) {
                        c = 22;
                        break;
                    }
                    break;
                case 2119:
                    if (strW1.equals("BI")) {
                        c = 23;
                        break;
                    }
                    break;
                case 2120:
                    if (strW1.equals("BJ")) {
                        c = 24;
                        break;
                    }
                    break;
                case 2122:
                    if (strW1.equals("BL")) {
                        c = 25;
                        break;
                    }
                    break;
                case 2123:
                    if (strW1.equals("BM")) {
                        c = 26;
                        break;
                    }
                    break;
                case 2124:
                    if (strW1.equals("BN")) {
                        c = 27;
                        break;
                    }
                    break;
                case 2125:
                    if (strW1.equals("BO")) {
                        c = 28;
                        break;
                    }
                    break;
                case 2127:
                    if (strW1.equals("BQ")) {
                        c = 29;
                        break;
                    }
                    break;
                case 2128:
                    if (strW1.equals("BR")) {
                        c = 30;
                        break;
                    }
                    break;
                case 2129:
                    if (strW1.equals("BS")) {
                        c = 31;
                        break;
                    }
                    break;
                case 2130:
                    if (strW1.equals("BT")) {
                        c = ' ';
                        break;
                    }
                    break;
                case 2133:
                    if (strW1.equals("BW")) {
                        c = '!';
                        break;
                    }
                    break;
                case 2135:
                    if (strW1.equals("BY")) {
                        c = '\"';
                        break;
                    }
                    break;
                case 2136:
                    if (strW1.equals("BZ")) {
                        c = MentionUtils.CHANNELS_CHAR;
                        break;
                    }
                    break;
                case 2142:
                    if (strW1.equals("CA")) {
                        c = '$';
                        break;
                    }
                    break;
                case 2145:
                    if (strW1.equals("CD")) {
                        c = '%';
                        break;
                    }
                    break;
                case 2147:
                    if (strW1.equals("CF")) {
                        c = '&';
                        break;
                    }
                    break;
                case 2148:
                    if (strW1.equals("CG")) {
                        c = '\'';
                        break;
                    }
                    break;
                case 2149:
                    if (strW1.equals("CH")) {
                        c = '(';
                        break;
                    }
                    break;
                case 2150:
                    if (strW1.equals("CI")) {
                        c = ')';
                        break;
                    }
                    break;
                case 2152:
                    if (strW1.equals("CK")) {
                        c = '*';
                        break;
                    }
                    break;
                case 2153:
                    if (strW1.equals("CL")) {
                        c = '+';
                        break;
                    }
                    break;
                case 2154:
                    if (strW1.equals("CM")) {
                        c = ',';
                        break;
                    }
                    break;
                case 2155:
                    if (strW1.equals("CN")) {
                        c = '-';
                        break;
                    }
                    break;
                case 2156:
                    if (strW1.equals("CO")) {
                        c = '.';
                        break;
                    }
                    break;
                case 2159:
                    if (strW1.equals("CR")) {
                        c = MentionUtils.SLASH_CHAR;
                        break;
                    }
                    break;
                case 2162:
                    if (strW1.equals("CU")) {
                        c = '0';
                        break;
                    }
                    break;
                case 2163:
                    if (strW1.equals("CV")) {
                        c = '1';
                        break;
                    }
                    break;
                case 2164:
                    if (strW1.equals("CW")) {
                        c = '2';
                        break;
                    }
                    break;
                case 2165:
                    if (strW1.equals("CX")) {
                        c = '3';
                        break;
                    }
                    break;
                case 2166:
                    if (strW1.equals("CY")) {
                        c = '4';
                        break;
                    }
                    break;
                case 2167:
                    if (strW1.equals("CZ")) {
                        c = '5';
                        break;
                    }
                    break;
                case 2177:
                    if (strW1.equals("DE")) {
                        c = '6';
                        break;
                    }
                    break;
                case 2182:
                    if (strW1.equals("DJ")) {
                        c = '7';
                        break;
                    }
                    break;
                case 2183:
                    if (strW1.equals("DK")) {
                        c = '8';
                        break;
                    }
                    break;
                case 2185:
                    if (strW1.equals("DM")) {
                        c = '9';
                        break;
                    }
                    break;
                case 2187:
                    if (strW1.equals("DO")) {
                        c = MentionUtils.EMOJIS_AND_STICKERS_CHAR;
                        break;
                    }
                    break;
                case 2198:
                    if (strW1.equals("DZ")) {
                        c = ';';
                        break;
                    }
                    break;
                case 2206:
                    if (strW1.equals("EC")) {
                        c = '<';
                        break;
                    }
                    break;
                case 2208:
                    if (strW1.equals("EE")) {
                        c = '=';
                        break;
                    }
                    break;
                case 2210:
                    if (strW1.equals("EG")) {
                        c = '>';
                        break;
                    }
                    break;
                case 2221:
                    if (strW1.equals("ER")) {
                        c = '?';
                        break;
                    }
                    break;
                case 2222:
                    if (strW1.equals("ES")) {
                        c = MentionUtils.MENTIONS_CHAR;
                        break;
                    }
                    break;
                case 2223:
                    if (strW1.equals("ET")) {
                        c = 'A';
                        break;
                    }
                    break;
                case 2243:
                    if (strW1.equals("FI")) {
                        c = 'B';
                        break;
                    }
                    break;
                case 2244:
                    if (strW1.equals("FJ")) {
                        c = 'C';
                        break;
                    }
                    break;
                case 2245:
                    if (strW1.equals("FK")) {
                        c = 'D';
                        break;
                    }
                    break;
                case 2247:
                    if (strW1.equals("FM")) {
                        c = 'E';
                        break;
                    }
                    break;
                case 2249:
                    if (strW1.equals("FO")) {
                        c = 'F';
                        break;
                    }
                    break;
                case 2252:
                    if (strW1.equals("FR")) {
                        c = 'G';
                        break;
                    }
                    break;
                case 2266:
                    if (strW1.equals("GA")) {
                        c = 'H';
                        break;
                    }
                    break;
                case 2267:
                    if (strW1.equals("GB")) {
                        c = 'I';
                        break;
                    }
                    break;
                case 2269:
                    if (strW1.equals("GD")) {
                        c = 'J';
                        break;
                    }
                    break;
                case 2270:
                    if (strW1.equals("GE")) {
                        c = 'K';
                        break;
                    }
                    break;
                case 2271:
                    if (strW1.equals("GF")) {
                        c = 'L';
                        break;
                    }
                    break;
                case 2272:
                    if (strW1.equals("GG")) {
                        c = 'M';
                        break;
                    }
                    break;
                case 2273:
                    if (strW1.equals("GH")) {
                        c = 'N';
                        break;
                    }
                    break;
                case 2274:
                    if (strW1.equals("GI")) {
                        c = 'O';
                        break;
                    }
                    break;
                case 2277:
                    if (strW1.equals("GL")) {
                        c = 'P';
                        break;
                    }
                    break;
                case 2278:
                    if (strW1.equals("GM")) {
                        c = 'Q';
                        break;
                    }
                    break;
                case 2279:
                    if (strW1.equals("GN")) {
                        c = 'R';
                        break;
                    }
                    break;
                case 2281:
                    if (strW1.equals("GP")) {
                        c = 'S';
                        break;
                    }
                    break;
                case 2282:
                    if (strW1.equals("GQ")) {
                        c = 'T';
                        break;
                    }
                    break;
                case 2283:
                    if (strW1.equals("GR")) {
                        c = 'U';
                        break;
                    }
                    break;
                case 2285:
                    if (strW1.equals("GT")) {
                        c = 'V';
                        break;
                    }
                    break;
                case 2286:
                    if (strW1.equals("GU")) {
                        c = 'W';
                        break;
                    }
                    break;
                case 2288:
                    if (strW1.equals("GW")) {
                        c = 'X';
                        break;
                    }
                    break;
                case 2290:
                    if (strW1.equals("GY")) {
                        c = 'Y';
                        break;
                    }
                    break;
                case 2307:
                    if (strW1.equals("HK")) {
                        c = 'Z';
                        break;
                    }
                    break;
                case 2310:
                    if (strW1.equals("HN")) {
                        c = '[';
                        break;
                    }
                    break;
                case 2314:
                    if (strW1.equals("HR")) {
                        c = '\\';
                        break;
                    }
                    break;
                case 2316:
                    if (strW1.equals("HT")) {
                        c = ']';
                        break;
                    }
                    break;
                case 2317:
                    if (strW1.equals("HU")) {
                        c = '^';
                        break;
                    }
                    break;
                case 2331:
                    if (strW1.equals("ID")) {
                        c = '_';
                        break;
                    }
                    break;
                case 2332:
                    if (strW1.equals("IE")) {
                        c = '`';
                        break;
                    }
                    break;
                case 2339:
                    if (strW1.equals("IL")) {
                        c = 'a';
                        break;
                    }
                    break;
                case 2340:
                    if (strW1.equals("IM")) {
                        c = 'b';
                        break;
                    }
                    break;
                case 2341:
                    if (strW1.equals("IN")) {
                        c = 'c';
                        break;
                    }
                    break;
                case 2342:
                    if (strW1.equals("IO")) {
                        c = 'd';
                        break;
                    }
                    break;
                case 2344:
                    if (strW1.equals("IQ")) {
                        c = 'e';
                        break;
                    }
                    break;
                case 2345:
                    if (strW1.equals("IR")) {
                        c = 'f';
                        break;
                    }
                    break;
                case 2346:
                    if (strW1.equals("IS")) {
                        c = 'g';
                        break;
                    }
                    break;
                case 2347:
                    if (strW1.equals("IT")) {
                        c = 'h';
                        break;
                    }
                    break;
                case 2363:
                    if (strW1.equals("JE")) {
                        c = 'i';
                        break;
                    }
                    break;
                case 2371:
                    if (strW1.equals("JM")) {
                        c = 'j';
                        break;
                    }
                    break;
                case 2373:
                    if (strW1.equals("JO")) {
                        c = 'k';
                        break;
                    }
                    break;
                case 2374:
                    if (strW1.equals("JP")) {
                        c = 'l';
                        break;
                    }
                    break;
                case 2394:
                    if (strW1.equals("KE")) {
                        c = 'm';
                        break;
                    }
                    break;
                case 2396:
                    if (strW1.equals("KG")) {
                        c = 'n';
                        break;
                    }
                    break;
                case 2397:
                    if (strW1.equals("KH")) {
                        c = 'o';
                        break;
                    }
                    break;
                case 2398:
                    if (strW1.equals("KI")) {
                        c = 'p';
                        break;
                    }
                    break;
                case 2402:
                    if (strW1.equals("KM")) {
                        c = 'q';
                        break;
                    }
                    break;
                case 2405:
                    if (strW1.equals("KP")) {
                        c = 'r';
                        break;
                    }
                    break;
                case 2407:
                    if (strW1.equals("KR")) {
                        c = 's';
                        break;
                    }
                    break;
                case 2412:
                    if (strW1.equals("KW")) {
                        c = 't';
                        break;
                    }
                    break;
                case 2414:
                    if (strW1.equals("KY")) {
                        c = 'u';
                        break;
                    }
                    break;
                case 2415:
                    if (strW1.equals("KZ")) {
                        c = 'v';
                        break;
                    }
                    break;
                case 2421:
                    if (strW1.equals("LA")) {
                        c = 'w';
                        break;
                    }
                    break;
                case 2422:
                    if (strW1.equals("LB")) {
                        c = 'x';
                        break;
                    }
                    break;
                case 2423:
                    if (strW1.equals("LC")) {
                        c = 'y';
                        break;
                    }
                    break;
                case 2429:
                    if (strW1.equals("LI")) {
                        c = 'z';
                        break;
                    }
                    break;
                case 2431:
                    if (strW1.equals("LK")) {
                        c = '{';
                        break;
                    }
                    break;
                case 2438:
                    if (strW1.equals("LR")) {
                        c = '|';
                        break;
                    }
                    break;
                case 2439:
                    if (strW1.equals("LS")) {
                        c = '}';
                        break;
                    }
                    break;
                case 2440:
                    if (strW1.equals("LT")) {
                        c = '~';
                        break;
                    }
                    break;
                case 2441:
                    if (strW1.equals("LU")) {
                        c = 127;
                        break;
                    }
                    break;
                case 2442:
                    if (strW1.equals("LV")) {
                        c = 128;
                        break;
                    }
                    break;
                case 2445:
                    if (strW1.equals("LY")) {
                        c = 129;
                        break;
                    }
                    break;
                case 2452:
                    if (strW1.equals("MA")) {
                        c = 130;
                        break;
                    }
                    break;
                case 2454:
                    if (strW1.equals("MC")) {
                        c = 131;
                        break;
                    }
                    break;
                case 2455:
                    if (strW1.equals("MD")) {
                        c = 132;
                        break;
                    }
                    break;
                case 2456:
                    if (strW1.equals("ME")) {
                        c = 133;
                        break;
                    }
                    break;
                case 2457:
                    if (strW1.equals("MF")) {
                        c = 134;
                        break;
                    }
                    break;
                case 2458:
                    if (strW1.equals("MG")) {
                        c = 135;
                        break;
                    }
                    break;
                case 2459:
                    if (strW1.equals("MH")) {
                        c = 136;
                        break;
                    }
                    break;
                case 2462:
                    if (strW1.equals("MK")) {
                        c = 137;
                        break;
                    }
                    break;
                case 2463:
                    if (strW1.equals("ML")) {
                        c = 138;
                        break;
                    }
                    break;
                case 2464:
                    if (strW1.equals("MM")) {
                        c = 139;
                        break;
                    }
                    break;
                case 2465:
                    if (strW1.equals("MN")) {
                        c = 140;
                        break;
                    }
                    break;
                case 2466:
                    if (strW1.equals("MO")) {
                        c = 141;
                        break;
                    }
                    break;
                case 2467:
                    if (strW1.equals("MP")) {
                        c = 142;
                        break;
                    }
                    break;
                case 2468:
                    if (strW1.equals("MQ")) {
                        c = 143;
                        break;
                    }
                    break;
                case 2469:
                    if (strW1.equals("MR")) {
                        c = 144;
                        break;
                    }
                    break;
                case 2470:
                    if (strW1.equals("MS")) {
                        c = 145;
                        break;
                    }
                    break;
                case 2471:
                    if (strW1.equals("MT")) {
                        c = 146;
                        break;
                    }
                    break;
                case 2472:
                    if (strW1.equals("MU")) {
                        c = 147;
                        break;
                    }
                    break;
                case 2473:
                    if (strW1.equals("MV")) {
                        c = 148;
                        break;
                    }
                    break;
                case 2474:
                    if (strW1.equals("MW")) {
                        c = 149;
                        break;
                    }
                    break;
                case 2475:
                    if (strW1.equals("MX")) {
                        c = 150;
                        break;
                    }
                    break;
                case 2476:
                    if (strW1.equals("MY")) {
                        c = 151;
                        break;
                    }
                    break;
                case 2477:
                    if (strW1.equals("MZ")) {
                        c = 152;
                        break;
                    }
                    break;
                case 2483:
                    if (strW1.equals("NA")) {
                        c = 153;
                        break;
                    }
                    break;
                case 2485:
                    if (strW1.equals("NC")) {
                        c = 154;
                        break;
                    }
                    break;
                case 2487:
                    if (strW1.equals("NE")) {
                        c = 155;
                        break;
                    }
                    break;
                case 2489:
                    if (strW1.equals("NG")) {
                        c = 156;
                        break;
                    }
                    break;
                case 2491:
                    if (strW1.equals("NI")) {
                        c = 157;
                        break;
                    }
                    break;
                case 2494:
                    if (strW1.equals("NL")) {
                        c = 158;
                        break;
                    }
                    break;
                case 2497:
                    if (strW1.equals("NO")) {
                        c = 159;
                        break;
                    }
                    break;
                case 2498:
                    if (strW1.equals("NP")) {
                        c = 160;
                        break;
                    }
                    break;
                case 2500:
                    if (strW1.equals("NR")) {
                        c = 161;
                        break;
                    }
                    break;
                case 2503:
                    if (strW1.equals("NU")) {
                        c = 162;
                        break;
                    }
                    break;
                case 2508:
                    if (strW1.equals("NZ")) {
                        c = 163;
                        break;
                    }
                    break;
                case 2526:
                    if (strW1.equals("OM")) {
                        c = 164;
                        break;
                    }
                    break;
                case 2545:
                    if (strW1.equals("PA")) {
                        c = 165;
                        break;
                    }
                    break;
                case 2549:
                    if (strW1.equals("PE")) {
                        c = 166;
                        break;
                    }
                    break;
                case 2550:
                    if (strW1.equals("PF")) {
                        c = 167;
                        break;
                    }
                    break;
                case 2551:
                    if (strW1.equals("PG")) {
                        c = 168;
                        break;
                    }
                    break;
                case 2552:
                    if (strW1.equals("PH")) {
                        c = 169;
                        break;
                    }
                    break;
                case 2555:
                    if (strW1.equals("PK")) {
                        c = 170;
                        break;
                    }
                    break;
                case 2556:
                    if (strW1.equals("PL")) {
                        c = 171;
                        break;
                    }
                    break;
                case 2557:
                    if (strW1.equals("PM")) {
                        c = 172;
                        break;
                    }
                    break;
                case 2562:
                    if (strW1.equals("PR")) {
                        c = 173;
                        break;
                    }
                    break;
                case 2563:
                    if (strW1.equals("PS")) {
                        c = 174;
                        break;
                    }
                    break;
                case 2564:
                    if (strW1.equals("PT")) {
                        c = 175;
                        break;
                    }
                    break;
                case 2567:
                    if (strW1.equals("PW")) {
                        c = 176;
                        break;
                    }
                    break;
                case 2569:
                    if (strW1.equals("PY")) {
                        c = 177;
                        break;
                    }
                    break;
                case 2576:
                    if (strW1.equals("QA")) {
                        c = 178;
                        break;
                    }
                    break;
                case 2611:
                    if (strW1.equals("RE")) {
                        c = 179;
                        break;
                    }
                    break;
                case 2621:
                    if (strW1.equals("RO")) {
                        c = 180;
                        break;
                    }
                    break;
                case 2625:
                    if (strW1.equals("RS")) {
                        c = 181;
                        break;
                    }
                    break;
                case 2627:
                    if (strW1.equals("RU")) {
                        c = 182;
                        break;
                    }
                    break;
                case 2629:
                    if (strW1.equals("RW")) {
                        c = 183;
                        break;
                    }
                    break;
                case 2638:
                    if (strW1.equals("SA")) {
                        c = 184;
                        break;
                    }
                    break;
                case 2639:
                    if (strW1.equals("SB")) {
                        c = 185;
                        break;
                    }
                    break;
                case 2640:
                    if (strW1.equals("SC")) {
                        c = 186;
                        break;
                    }
                    break;
                case 2641:
                    if (strW1.equals("SD")) {
                        c = 187;
                        break;
                    }
                    break;
                case 2642:
                    if (strW1.equals("SE")) {
                        c = 188;
                        break;
                    }
                    break;
                case 2644:
                    if (strW1.equals("SG")) {
                        c = 189;
                        break;
                    }
                    break;
                case 2645:
                    if (strW1.equals("SH")) {
                        c = 190;
                        break;
                    }
                    break;
                case 2646:
                    if (strW1.equals("SI")) {
                        c = 191;
                        break;
                    }
                    break;
                case 2647:
                    if (strW1.equals("SJ")) {
                        c = 192;
                        break;
                    }
                    break;
                case 2648:
                    if (strW1.equals("SK")) {
                        c = 193;
                        break;
                    }
                    break;
                case 2649:
                    if (strW1.equals("SL")) {
                        c = 194;
                        break;
                    }
                    break;
                case 2650:
                    if (strW1.equals("SM")) {
                        c = 195;
                        break;
                    }
                    break;
                case 2651:
                    if (strW1.equals("SN")) {
                        c = 196;
                        break;
                    }
                    break;
                case 2652:
                    if (strW1.equals("SO")) {
                        c = 197;
                        break;
                    }
                    break;
                case 2655:
                    if (strW1.equals("SR")) {
                        c = 198;
                        break;
                    }
                    break;
                case 2656:
                    if (strW1.equals("SS")) {
                        c = 199;
                        break;
                    }
                    break;
                case 2657:
                    if (strW1.equals("ST")) {
                        c = 200;
                        break;
                    }
                    break;
                case 2659:
                    if (strW1.equals("SV")) {
                        c = 201;
                        break;
                    }
                    break;
                case 2661:
                    if (strW1.equals("SX")) {
                        c = 202;
                        break;
                    }
                    break;
                case 2662:
                    if (strW1.equals("SY")) {
                        c = 203;
                        break;
                    }
                    break;
                case 2663:
                    if (strW1.equals("SZ")) {
                        c = 204;
                        break;
                    }
                    break;
                case 2671:
                    if (strW1.equals("TC")) {
                        c = 205;
                        break;
                    }
                    break;
                case 2672:
                    if (strW1.equals("TD")) {
                        c = 206;
                        break;
                    }
                    break;
                case 2675:
                    if (strW1.equals("TG")) {
                        c = 207;
                        break;
                    }
                    break;
                case 2676:
                    if (strW1.equals("TH")) {
                        c = 208;
                        break;
                    }
                    break;
                case 2678:
                    if (strW1.equals("TJ")) {
                        c = 209;
                        break;
                    }
                    break;
                case 2680:
                    if (strW1.equals("TL")) {
                        c = 210;
                        break;
                    }
                    break;
                case 2681:
                    if (strW1.equals("TM")) {
                        c = 211;
                        break;
                    }
                    break;
                case 2682:
                    if (strW1.equals("TN")) {
                        c = 212;
                        break;
                    }
                    break;
                case 2683:
                    if (strW1.equals("TO")) {
                        c = 213;
                        break;
                    }
                    break;
                case 2686:
                    if (strW1.equals("TR")) {
                        c = 214;
                        break;
                    }
                    break;
                case 2688:
                    if (strW1.equals("TT")) {
                        c = 215;
                        break;
                    }
                    break;
                case 2690:
                    if (strW1.equals("TV")) {
                        c = 216;
                        break;
                    }
                    break;
                case 2691:
                    if (strW1.equals("TW")) {
                        c = 217;
                        break;
                    }
                    break;
                case 2694:
                    if (strW1.equals("TZ")) {
                        c = 218;
                        break;
                    }
                    break;
                case 2700:
                    if (strW1.equals("UA")) {
                        c = 219;
                        break;
                    }
                    break;
                case 2706:
                    if (strW1.equals("UG")) {
                        c = 220;
                        break;
                    }
                    break;
                case 2718:
                    if (strW1.equals("US")) {
                        c = 221;
                        break;
                    }
                    break;
                case 2724:
                    if (strW1.equals("UY")) {
                        c = 222;
                        break;
                    }
                    break;
                case 2725:
                    if (strW1.equals("UZ")) {
                        c = 223;
                        break;
                    }
                    break;
                case 2733:
                    if (strW1.equals("VC")) {
                        c = 224;
                        break;
                    }
                    break;
                case 2735:
                    if (strW1.equals("VE")) {
                        c = 225;
                        break;
                    }
                    break;
                case 2737:
                    if (strW1.equals("VG")) {
                        c = 226;
                        break;
                    }
                    break;
                case 2739:
                    if (strW1.equals("VI")) {
                        c = 227;
                        break;
                    }
                    break;
                case 2744:
                    if (strW1.equals("VN")) {
                        c = 228;
                        break;
                    }
                    break;
                case 2751:
                    if (strW1.equals("VU")) {
                        c = 229;
                        break;
                    }
                    break;
                case 2767:
                    if (strW1.equals("WF")) {
                        c = 230;
                        break;
                    }
                    break;
                case 2780:
                    if (strW1.equals("WS")) {
                        c = 231;
                        break;
                    }
                    break;
                case 2803:
                    if (strW1.equals("XK")) {
                        c = 232;
                        break;
                    }
                    break;
                case 2828:
                    if (strW1.equals("YE")) {
                        c = 233;
                        break;
                    }
                    break;
                case 2843:
                    if (strW1.equals("YT")) {
                        c = 234;
                        break;
                    }
                    break;
                case 2855:
                    if (strW1.equals("ZA")) {
                        c = 235;
                        break;
                    }
                    break;
                case 2867:
                    if (strW1.equals("ZM")) {
                        c = 236;
                        break;
                    }
                    break;
                case 2877:
                    if (strW1.equals("ZW")) {
                        c = 237;
                        break;
                    }
                    break;
            }
            switch (c) {
                case 0:
                case 26:
                case 'P':
                case 'y':
                    iArr = new int[]{1, 2, 0, 0, 2, 2};
                    break;
                case 1:
                    iArr = new int[]{1, 4, 4, 4, 3, 2};
                    break;
                case 2:
                case ']':
                case 155:
                case Opcodes.NEW /* 187 */:
                case 196:
                case 206:
                case HideBottomViewOnScrollBehavior.ENTER_ANIMATION_DURATION /* 225 */:
                case 233:
                    iArr = new int[]{4, 4, 4, 4, 2, 2};
                    break;
                case 3:
                    iArr = new int[]{2, 3, 1, 2, 2, 2};
                    break;
                case 4:
                case 25:
                case '3':
                case '9':
                case 'J':
                case Opcodes.I2B /* 145 */:
                case 224:
                    iArr = new int[]{1, 2, 2, 2, 2, 2};
                    break;
                case 5:
                case 16:
                case 'u':
                    iArr = new int[]{1, 2, 0, 1, 2, 2};
                    break;
                case 6:
                    iArr = new int[]{2, 3, 2, 4, 2, 2};
                    break;
                case 7:
                case ',':
                    iArr = new int[]{3, 4, 3, 2, 2, 2};
                    break;
                case '\b':
                case '?':
                case 'd':
                case Opcodes.IF_ICMPGE /* 162 */:
                case Opcodes.ARRAYLENGTH /* 190 */:
                case Opcodes.IFNONNULL /* 199 */:
                case 216:
                    iArr = new int[]{4, 2, 2, 2, 2, 2};
                    break;
                case '\t':
                    iArr = new int[]{2, 4, 1, 1, 2, 2};
                    break;
                case '\n':
                    iArr = new int[]{2, 2, 2, 3, 2, 2};
                    break;
                case 11:
                case '(':
                case 'g':
                case Opcodes.NEWARRAY /* 188 */:
                case Opcodes.INSTANCEOF /* 193 */:
                    iArr = new int[]{0, 0, 0, 0, 0, 2};
                    break;
                case '\f':
                    iArr = new int[]{0, 1, 0, 1, 2, 2};
                    break;
                case '\r':
                case 'W':
                    iArr = new int[]{1, 2, 4, 4, 2, 2};
                    break;
                case 14:
                case 'O':
                case 'z':
                case Opcodes.D2I /* 142 */:
                case Opcodes.IRETURN /* 172 */:
                case Opcodes.CHECKCAST /* 192 */:
                case Opcodes.MONITOREXIT /* 195 */:
                    iArr = new int[]{0, 2, 2, 2, 2, 2};
                    break;
                case 15:
                case 154:
                    iArr = new int[]{3, 2, 4, 4, 2, 2};
                    break;
                case 17:
                case 'F':
                case 'M':
                    iArr = new int[]{0, 2, 0, 0, 2, 2};
                    break;
                case 18:
                case Opcodes.DCMPL /* 151 */:
                    iArr = new int[]{2, 1, 3, 3, 2, 2};
                    break;
                case 19:
                    iArr = new int[]{0, 0, 3, 3, 2, 2};
                    break;
                case 20:
                    iArr = new int[]{4, 3, 4, 3, 2, 2};
                    break;
                case 21:
                case '5':
                case Opcodes.ATHROW /* 191 */:
                    iArr = new int[]{0, 0, 0, 0, 1, 2};
                    break;
                case 22:
                    iArr = new int[]{1, 2, 2, 4, 4, 2};
                    break;
                case 23:
                case ';':
                case 203:
                case 210:
                    iArr = new int[]{4, 3, 4, 4, 2, 2};
                    break;
                case 24:
                    iArr = new int[]{4, 4, 3, 4, 2, 2};
                    break;
                case 27:
                    iArr = new int[]{3, 2, 1, 1, 2, 2};
                    break;
                case 28:
                    iArr = new int[]{1, 3, 3, 2, 2, 2};
                    break;
                case 29:
                    iArr = new int[]{1, 2, 2, 0, 2, 2};
                    break;
                case 30:
                case Opcodes.IFNULL /* 198 */:
                    iArr = new int[]{2, 3, 2, 2, 2, 2};
                    break;
                case 31:
                    iArr = new int[]{4, 2, 2, 3, 2, 2};
                    break;
                case ' ':
                    iArr = new int[]{3, 1, 3, 2, 2, 2};
                    break;
                case '!':
                case 'Y':
                    iArr = new int[]{3, 4, 1, 0, 2, 2};
                    break;
                case '\"':
                    iArr = new int[]{0, 1, 1, 3, 2, 2};
                    break;
                case '#':
                    iArr = new int[]{2, 4, 2, 2, 2, 2};
                    break;
                case '$':
                    iArr = new int[]{0, 2, 1, 2, 4, 1};
                    break;
                case '%':
                    iArr = new int[]{4, 2, 3, 1, 2, 2};
                    break;
                case '&':
                    iArr = new int[]{4, 2, 3, 2, 2, 2};
                    break;
                case '\'':
                case 150:
                    iArr = new int[]{2, 4, 3, 4, 2, 2};
                    break;
                case ')':
                    iArr = new int[]{3, 3, 3, 4, 2, 2};
                    break;
                case '*':
                    iArr = new int[]{2, 2, 2, 1, 2, 2};
                    break;
                case '+':
                case Opcodes.LOOKUPSWITCH /* 171 */:
                case 221:
                    iArr = new int[]{1, 1, 2, 2, 3, 2};
                    break;
                case '-':
                    iArr = new int[]{2, 0, 2, 2, 3, 1};
                    break;
                case '.':
                    iArr = new int[]{2, 2, 4, 2, 2, 2};
                    break;
                case '/':
                    iArr = new int[]{2, 2, 4, 4, 2, 2};
                    break;
                case '0':
                case Opcodes.JSR /* 168 */:
                    iArr = new int[]{4, 4, 3, 2, 2, 2};
                    break;
                case '1':
                    iArr = new int[]{2, 3, 1, 0, 2, 2};
                    break;
                case '2':
                    iArr = new int[]{2, 2, 0, 0, 2, 2};
                    break;
                case '4':
                    iArr = new int[]{1, 0, 0, 0, 1, 2};
                    break;
                case '6':
                    iArr = new int[]{0, 0, 2, 2, 1, 2};
                    break;
                case '7':
                    iArr = new int[]{4, 1, 4, 4, 2, 2};
                    break;
                case '8':
                    iArr = new int[]{0, 0, 1, 0, 0, 2};
                    break;
                case ':':
                case 'j':
                    iArr = new int[]{3, 4, 4, 4, 2, 2};
                    break;
                case '<':
                    iArr = new int[]{2, 4, 2, 1, 2, 2};
                    break;
                case '=':
                case '~':
                case 128:
                case Opcodes.I2C /* 146 */:
                    iArr = new int[]{0, 0, 0, 0, 2, 2};
                    break;
                case '>':
                    iArr = new int[]{3, 4, 2, 3, 2, 2};
                    break;
                case '@':
                case '`':
                    iArr = new int[]{0, 1, 1, 1, 2, 2};
                    break;
                case 'A':
                    iArr = new int[]{4, 4, 3, 1, 2, 2};
                    break;
                case 'B':
                    iArr = new int[]{0, 0, 0, 1, 0, 2};
                    break;
                case 'C':
                    iArr = new int[]{3, 1, 3, 3, 2, 2};
                    break;
                case 'D':
                case 'r':
                case 130:
                case Opcodes.DCMPG /* 152 */:
                case 200:
                    iArr = new int[]{3, 2, 2, 2, 2, 2};
                    break;
                case 'E':
                    iArr = new int[]{3, 2, 4, 2, 2, 2};
                    break;
                case 'G':
                    iArr = new int[]{1, 1, 2, 1, 1, 1};
                    break;
                case 'H':
                    iArr = new int[]{2, 3, 1, 1, 2, 2};
                    break;
                case 'I':
                    iArr = new int[]{0, 0, 1, 1, 2, 3};
                    break;
                case 'K':
                    iArr = new int[]{1, 1, 1, 3, 2, 2};
                    break;
                case 'L':
                case 'S':
                case Opcodes.D2L /* 143 */:
                    iArr = new int[]{2, 1, 2, 3, 2, 2};
                    break;
                case 'N':
                    iArr = new int[]{3, 2, 3, 2, 2, 2};
                    break;
                case 'Q':
                case 230:
                    iArr = new int[]{4, 2, 2, 4, 2, 2};
                    break;
                case 'R':
                    iArr = new int[]{4, 3, 4, 2, 2, 2};
                    break;
                case 'T':
                    iArr = new int[]{4, 2, 3, 4, 2, 2};
                    break;
                case 'U':
                case '\\':
                case Opcodes.IINC /* 132 */:
                case Opcodes.L2F /* 137 */:
                case Opcodes.PUTFIELD /* 181 */:
                    iArr = new int[]{1, 0, 0, 0, 2, 2};
                    break;
                case 'V':
                    iArr = new int[]{2, 3, 2, 1, 2, 2};
                    break;
                case 'X':
                case 218:
                    iArr = new int[]{3, 4, 3, 3, 2, 2};
                    break;
                case 'Z':
                    iArr = new int[]{0, 1, 2, 3, 2, 0};
                    break;
                case '[':
                case Opcodes.TABLESWITCH /* 170 */:
                case Opcodes.MULTIANEWARRAY /* 197 */:
                    iArr = new int[]{3, 2, 3, 3, 2, 2};
                    break;
                case '^':
                    iArr = new int[]{0, 0, 0, 1, 3, 2};
                    break;
                case '_':
                    iArr = new int[]{3, 2, 3, 3, 3, 2};
                    break;
                case 'a':
                    iArr = new int[]{1, 1, 2, 3, 4, 2};
                    break;
                case 'b':
                    iArr = new int[]{0, 2, 0, 1, 2, 2};
                    break;
                case 'c':
                    iArr = new int[]{1, 1, 3, 2, 4, 3};
                    break;
                case 'e':
                case 220:
                    iArr = new int[]{3, 3, 3, 3, 2, 2};
                    break;
                case 'f':
                    iArr = new int[]{3, 0, 1, 1, 3, 0};
                    break;
                case 'h':
                    iArr = new int[]{0, 1, 0, 1, 1, 2};
                    break;
                case 'i':
                    iArr = new int[]{3, 2, 1, 2, 2, 2};
                    break;
                case 'k':
                case Opcodes.I2L /* 133 */:
                    iArr = new int[]{1, 0, 0, 1, 2, 2};
                    break;
                case 'l':
                    iArr = new int[]{0, 1, 0, 1, 1, 1};
                    break;
                case 'm':
                    iArr = new int[]{3, 3, 2, 2, 2, 2};
                    break;
                case 'n':
                    iArr = new int[]{2, 1, 1, 1, 2, 2};
                    break;
                case 'o':
                    iArr = new int[]{1, 1, 4, 2, 2, 2};
                    break;
                case 'p':
                case 'q':
                case Opcodes.LOR /* 129 */:
                case Opcodes.INVOKEINTERFACE /* 185 */:
                    iArr = new int[]{4, 2, 4, 3, 2, 2};
                    break;
                case 's':
                    iArr = new int[]{0, 0, 1, 3, 4, 4};
                    break;
                case 't':
                    iArr = new int[]{1, 1, 0, 0, 0, 2};
                    break;
                case 'v':
                    iArr = new int[]{1, 1, 2, 2, 2, 2};
                    break;
                case 'w':
                case 222:
                    iArr = new int[]{2, 2, 1, 2, 2, 2};
                    break;
                case 'x':
                    iArr = new int[]{3, 2, 1, 4, 2, 2};
                    break;
                case '{':
                    iArr = new int[]{3, 1, 3, 4, 4, 2};
                    break;
                case '|':
                    iArr = new int[]{3, 4, 4, 3, 2, 2};
                    break;
                case Opcodes.LUSHR /* 125 */:
                    iArr = new int[]{3, 3, 4, 3, 2, 2};
                    break;
                case Opcodes.LAND /* 127 */:
                    iArr = new int[]{1, 0, 2, 2, 2, 2};
                    break;
                case Opcodes.LXOR /* 131 */:
                    iArr = new int[]{0, 2, 2, 0, 2, 2};
                    break;
                case Opcodes.I2F /* 134 */:
                    iArr = new int[]{1, 2, 1, 0, 2, 2};
                    break;
                case Opcodes.I2D /* 135 */:
                    iArr = new int[]{3, 4, 2, 2, 2, 2};
                    break;
                case Opcodes.L2I /* 136 */:
                    iArr = new int[]{3, 2, 2, 4, 2, 2};
                    break;
                case Opcodes.L2D /* 138 */:
                    iArr = new int[]{4, 3, 3, 1, 2, 2};
                    break;
                case Opcodes.F2I /* 139 */:
                    iArr = new int[]{2, 4, 3, 3, 2, 2};
                    break;
                case Opcodes.F2L /* 140 */:
                    iArr = new int[]{2, 0, 1, 2, 2, 2};
                    break;
                case Opcodes.F2D /* 141 */:
                    iArr = new int[]{0, 2, 4, 4, 2, 2};
                    break;
                case Opcodes.D2F /* 144 */:
                    iArr = new int[]{4, 1, 3, 4, 2, 2};
                    break;
                case Opcodes.I2S /* 147 */:
                    iArr = new int[]{3, 1, 1, 2, 2, 2};
                    break;
                case Opcodes.LCMP /* 148 */:
                    iArr = new int[]{3, 4, 1, 4, 2, 2};
                    break;
                case Opcodes.FCMPL /* 149 */:
                    iArr = new int[]{4, 2, 1, 0, 2, 2};
                    break;
                case 153:
                    iArr = new int[]{4, 3, 2, 2, 2, 2};
                    break;
                case 156:
                    iArr = new int[]{3, 4, 1, 1, 2, 2};
                    break;
                case 157:
                    iArr = new int[]{2, 3, 4, 3, 2, 2};
                    break;
                case 158:
                    iArr = new int[]{0, 0, 3, 2, 0, 4};
                    break;
                case Opcodes.IF_ICMPEQ /* 159 */:
                    iArr = new int[]{0, 0, 2, 0, 0, 2};
                    break;
                case Opcodes.IF_ICMPNE /* 160 */:
                    iArr = new int[]{2, 1, 4, 3, 2, 2};
                    break;
                case Opcodes.IF_ICMPLT /* 161 */:
                    iArr = new int[]{3, 2, 2, 0, 2, 2};
                    break;
                case Opcodes.IF_ICMPGT /* 163 */:
                    iArr = new int[]{1, 0, 1, 2, 4, 2};
                    break;
                case Opcodes.IF_ICMPLE /* 164 */:
                    iArr = new int[]{2, 3, 1, 3, 4, 2};
                    break;
                case Opcodes.IF_ACMPEQ /* 165 */:
                    iArr = new int[]{1, 3, 3, 3, 2, 2};
                    break;
                case Opcodes.IF_ACMPNE /* 166 */:
                    iArr = new int[]{2, 3, 4, 4, 4, 2};
                    break;
                case Opcodes.GOTO /* 167 */:
                    iArr = new int[]{2, 3, 3, 1, 2, 2};
                    break;
                case Opcodes.RET /* 169 */:
                    iArr = new int[]{2, 2, 3, 3, 3, 2};
                    break;
                case Opcodes.LRETURN /* 173 */:
                    iArr = new int[]{2, 3, 2, 2, 3, 3};
                    break;
                case Opcodes.FRETURN /* 174 */:
                    iArr = new int[]{3, 4, 1, 2, 2, 2};
                    break;
                case 175:
                    iArr = new int[]{0, 1, 0, 0, 2, 2};
                    break;
                case Opcodes.ARETURN /* 176 */:
                    iArr = new int[]{2, 2, 4, 1, 2, 2};
                    break;
                case Opcodes.RETURN /* 177 */:
                    iArr = new int[]{2, 2, 3, 2, 2, 2};
                    break;
                case Opcodes.GETSTATIC /* 178 */:
                    iArr = new int[]{2, 4, 2, 4, 4, 2};
                    break;
                case Opcodes.PUTSTATIC /* 179 */:
                    iArr = new int[]{1, 1, 1, 2, 2, 2};
                    break;
                case 180:
                    iArr = new int[]{0, 0, 1, 1, 1, 2};
                    break;
                case Opcodes.INVOKEVIRTUAL /* 182 */:
                    iArr = new int[]{0, 0, 0, 1, 2, 2};
                    break;
                case Opcodes.INVOKESPECIAL /* 183 */:
                    iArr = new int[]{3, 4, 3, 0, 2, 2};
                    break;
                case Opcodes.INVOKESTATIC /* 184 */:
                case 212:
                case 226:
                    iArr = new int[]{2, 2, 1, 1, 2, 2};
                    break;
                case Opcodes.INVOKEDYNAMIC /* 186 */:
                    iArr = new int[]{4, 3, 0, 2, 2, 2};
                    break;
                case Opcodes.ANEWARRAY /* 189 */:
                    iArr = new int[]{1, 1, 2, 3, 1, 4};
                    break;
                case Opcodes.MONITORENTER /* 194 */:
                    iArr = new int[]{4, 3, 4, 1, 2, 2};
                    break;
                case 201:
                    iArr = new int[]{2, 2, 3, 3, 2, 2};
                    break;
                case 202:
                case 205:
                    iArr = new int[]{2, 2, 1, 0, 2, 2};
                    break;
                case 204:
                    iArr = new int[]{4, 3, 2, 4, 2, 2};
                    break;
                case 207:
                    iArr = new int[]{3, 3, 2, 0, 2, 2};
                    break;
                case 208:
                    iArr = new int[]{0, 3, 2, 3, 3, 0};
                    break;
                case 209:
                    iArr = new int[]{4, 2, 4, 4, 2, 2};
                    break;
                case 211:
                    iArr = new int[]{4, 2, 4, 2, 2, 2};
                    break;
                case 213:
                    iArr = new int[]{4, 2, 3, 3, 2, 2};
                    break;
                case 214:
                    iArr = new int[]{1, 1, 0, 1, 2, 2};
                    break;
                case 215:
                    iArr = new int[]{1, 4, 1, 1, 2, 2};
                    break;
                case 217:
                    iArr = new int[]{0, 0, 0, 0, 0, 0};
                    break;
                case 219:
                    iArr = new int[]{0, 3, 1, 1, 2, 2};
                    break;
                case 223:
                    iArr = new int[]{2, 2, 3, 4, 2, 2};
                    break;
                case 227:
                    iArr = new int[]{1, 2, 1, 3, 2, 2};
                    break;
                case 228:
                    iArr = new int[]{0, 3, 3, 4, 2, 2};
                    break;
                case 229:
                    iArr = new int[]{4, 2, 2, 1, 2, 2};
                    break;
                case 231:
                    iArr = new int[]{3, 1, 2, 1, 2, 2};
                    break;
                case 232:
                    iArr = new int[]{1, 1, 1, 1, 2, 2};
                    break;
                case 234:
                    iArr = new int[]{4, 1, 1, 1, 2, 2};
                    break;
                case 235:
                    iArr = new int[]{3, 3, 1, 1, 1, 2};
                    break;
                case 236:
                    iArr = new int[]{3, 3, 4, 2, 2, 2};
                    break;
                case 237:
                    iArr = new int[]{3, 2, 4, 3, 2, 2};
                    break;
                default:
                    iArr = new int[]{2, 2, 2, 2, 2, 2};
                    break;
            }
            HashMap map = new HashMap(8);
            map.put(0, 1000000L);
            ImmutableList2<Long> immutableList22 = DefaultBandwidthMeter.a;
            map.put(2, immutableList22.get(iArr[0]));
            map.put(3, DefaultBandwidthMeter.f945b.get(iArr[1]));
            map.put(4, DefaultBandwidthMeter.c.get(iArr[2]));
            map.put(5, DefaultBandwidthMeter.d.get(iArr[3]));
            map.put(10, DefaultBandwidthMeter.e.get(iArr[4]));
            map.put(9, DefaultBandwidthMeter.f.get(iArr[5]));
            map.put(7, immutableList22.get(iArr[0]));
            this.f947b = map;
            this.c = 2000;
            this.d = Clock4.a;
            this.e = true;
        }
    }

    public DefaultBandwidthMeter(Context context, Map map, int i, Clock4 clock4, boolean z2, a aVar) {
        NetworkTypeObserver networkTypeObserver;
        int i2;
        this.h = ImmutableMap2.a(map);
        this.j = new SlidingPercentile(i);
        this.k = clock4;
        this.l = z2;
        if (context == null) {
            this.p = 0;
            this.f946s = h(0);
            return;
        }
        synchronized (NetworkTypeObserver.class) {
            if (NetworkTypeObserver.a == null) {
                NetworkTypeObserver.a = new NetworkTypeObserver(context);
            }
            networkTypeObserver = NetworkTypeObserver.a;
        }
        synchronized (networkTypeObserver.d) {
            i2 = networkTypeObserver.e;
        }
        this.p = i2;
        this.f946s = h(i2);
        b.i.a.c.e3.b bVar = new b.i.a.c.e3.b(this);
        Iterator<WeakReference<NetworkTypeObserver.b>> it = networkTypeObserver.c.iterator();
        while (it.hasNext()) {
            WeakReference<NetworkTypeObserver.b> next = it.next();
            if (next.get() == null) {
                networkTypeObserver.c.remove(next);
            }
        }
        networkTypeObserver.c.add(new WeakReference<>(bVar));
        networkTypeObserver.f982b.post(new b.i.a.c.f3.c(networkTypeObserver, bVar));
    }

    public static boolean i(DataSpec dataSpec, boolean z2) {
        return z2 && !dataSpec.c(8);
    }

    @Override // b.i.a.c.e3.TransferListener
    public synchronized void a(DataSource3 dataSource3, DataSpec dataSpec, boolean z2) {
        if (i(dataSpec, z2)) {
            AnimatableValueParser.D(this.m > 0);
            long jD = this.k.d();
            int i = (int) (jD - this.n);
            this.q += i;
            long j = this.r;
            long j2 = this.o;
            this.r = j + j2;
            if (i > 0) {
                this.j.a((int) Math.sqrt(j2), (j2 * 8000.0f) / i);
                if (this.q >= 2000 || this.r >= Permission.VIEW_GUILD_ANALYTICS) {
                    this.f946s = (long) this.j.b(0.5f);
                }
                j(i, this.o, this.f946s);
                this.n = jD;
                this.o = 0L;
            }
            this.m--;
        }
    }

    @Override // b.i.a.c.e3.TransferListener
    public synchronized void b(DataSource3 dataSource3, DataSpec dataSpec, boolean z2) {
        if (i(dataSpec, z2)) {
            if (this.m == 0) {
                this.n = this.k.d();
            }
            this.m++;
        }
    }

    @Override // b.i.a.c.e3.BandwidthMeter
    public TransferListener c() {
        return this;
    }

    @Override // b.i.a.c.e3.BandwidthMeter
    public void d(BandwidthMeter.a aVar) {
        this.i.a(aVar);
    }

    @Override // b.i.a.c.e3.TransferListener
    public synchronized void e(DataSource3 dataSource3, DataSpec dataSpec, boolean z2, int i) {
        if (i(dataSpec, z2)) {
            this.o += i;
        }
    }

    @Override // b.i.a.c.e3.BandwidthMeter
    public void f(Handler handler, BandwidthMeter.a aVar) {
        BandwidthMeter.a.C0029a c0029a = this.i;
        Objects.requireNonNull(c0029a);
        c0029a.a(aVar);
        c0029a.a.add(new BandwidthMeter.a.C0029a.C0030a(handler, aVar));
    }

    @Override // b.i.a.c.e3.TransferListener
    public void g(DataSource3 dataSource3, DataSpec dataSpec, boolean z2) {
    }

    public final long h(int i) {
        Long l = this.h.get(Integer.valueOf(i));
        if (l == null) {
            l = this.h.get(0);
        }
        if (l == null) {
            l = 1000000L;
        }
        return l.longValue();
    }

    public final void j(int i, long j, long j2) {
        if (i == 0 && j == 0 && j2 == this.t) {
            return;
        }
        this.t = j2;
        Iterator<BandwidthMeter.a.C0029a.C0030a> it = this.i.a.iterator();
        while (it.hasNext()) {
            BandwidthMeter.a.C0029a.C0030a next = it.next();
            if (!next.c) {
                next.a.post(new b.i.a.c.e3.a(next, i, j, j2));
            }
        }
    }
}
