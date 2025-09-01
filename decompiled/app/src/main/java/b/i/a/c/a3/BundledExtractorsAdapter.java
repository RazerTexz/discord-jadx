package b.i.a.c.a3;

import android.net.Uri;
import androidx.annotation.Nullable;
import b.c.a.a0.AnimatableValueParser;
import b.d.b.a.outline;
import b.i.a.c.e3.DataReader;
import b.i.a.c.f3.Util2;
import b.i.a.c.x2.DefaultExtractorInput;
import b.i.a.c.x2.Extractor;
import b.i.a.c.x2.ExtractorInput;
import b.i.a.c.x2.ExtractorOutput;
import b.i.a.c.x2.ExtractorsFactory2;
import com.google.android.exoplayer2.source.UnrecognizedInputFormatException;
import java.io.EOFException;
import java.io.IOException;
import java.util.List;
import java.util.Map;
import java.util.Objects;

/* compiled from: BundledExtractorsAdapter.java */
/* renamed from: b.i.a.c.a3.m, reason: use source file name */
/* loaded from: classes3.dex */
public final class BundledExtractorsAdapter implements ProgressiveMediaExtractor {
    public final ExtractorsFactory2 a;

    /* renamed from: b, reason: collision with root package name */
    @Nullable
    public Extractor f828b;

    @Nullable
    public ExtractorInput c;

    public BundledExtractorsAdapter(ExtractorsFactory2 extractorsFactory2) {
        this.a = extractorsFactory2;
    }

    public long a() {
        ExtractorInput extractorInput = this.c;
        if (extractorInput != null) {
            return extractorInput.getPosition();
        }
        return -1L;
    }

    public void b(DataReader dataReader, Uri uri, Map<String, List<String>> map, long j, long j2, ExtractorOutput extractorOutput) throws IOException {
        DefaultExtractorInput defaultExtractorInput = new DefaultExtractorInput(dataReader, j, j2);
        this.c = defaultExtractorInput;
        if (this.f828b != null) {
            return;
        }
        Extractor[] extractorArrB = this.a.b(uri, map);
        boolean z2 = true;
        if (extractorArrB.length == 1) {
            this.f828b = extractorArrB[0];
        } else {
            int length = extractorArrB.length;
            int i = 0;
            while (true) {
                if (i >= length) {
                    break;
                }
                Extractor extractor = extractorArrB[i];
                try {
                } catch (EOFException unused) {
                    if (this.f828b != null || defaultExtractorInput.d == j) {
                    }
                } catch (Throwable th) {
                    if (this.f828b == null && defaultExtractorInput.d != j) {
                        z2 = false;
                    }
                    AnimatableValueParser.D(z2);
                    defaultExtractorInput.f = 0;
                    throw th;
                }
                if (extractor.b(defaultExtractorInput)) {
                    this.f828b = extractor;
                    AnimatableValueParser.D(true);
                    defaultExtractorInput.f = 0;
                    break;
                } else {
                    boolean z3 = this.f828b != null || defaultExtractorInput.d == j;
                    AnimatableValueParser.D(z3);
                    defaultExtractorInput.f = 0;
                    i++;
                }
            }
            if (this.f828b == null) {
                int i2 = Util2.a;
                StringBuilder sb = new StringBuilder();
                for (int i3 = 0; i3 < extractorArrB.length; i3++) {
                    sb.append(extractorArrB[i3].getClass().getSimpleName());
                    if (i3 < extractorArrB.length - 1) {
                        sb.append(", ");
                    }
                }
                String string = sb.toString();
                StringBuilder sb2 = new StringBuilder(outline.b(string, 58));
                sb2.append("None of the available extractors (");
                sb2.append(string);
                sb2.append(") could read the stream.");
                String string2 = sb2.toString();
                Objects.requireNonNull(uri);
                throw new UnrecognizedInputFormatException(string2, uri);
            }
        }
        this.f828b.f(extractorOutput);
    }
}
