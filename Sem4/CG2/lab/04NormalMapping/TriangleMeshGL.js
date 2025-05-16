// @ts-check
// Use previous assignment
        
        const ib = gl.createBuffer();
        gl.bindBuffer(gl.ELEMENT_ARRAY_BUFFER, ib);
        gl.bufferData(gl.ELEMENT_ARRAY_BUFFER, new Uint32Array(triangles), gl.STATIC_DRAW);        

        let f = this.computeTangentFrame(triangles, positions, texCoords);
        const tangentAttributeLocation = 4;
        const biTangentAttributeLocation = 5;
        const tab = gl.createBuffer();
        gl.bindBuffer(gl.ARRAY_BUFFER, tab);
        gl.bufferData(gl.ARRAY_BUFFER, new Float32Array(f.outTangents), gl.STATIC_DRAW);
        gl.vertexAttribPointer(tangentAttributeLocation, 3, gl.FLOAT, false, 0, 0);
        gl.enableVertexAttribArray(tangentAttributeLocation);
        
        const bib = gl.createBuffer();
        gl.bindBuffer(gl.ARRAY_BUFFER, bib);
        gl.bufferData(gl.ARRAY_BUFFER, new Float32Array(f.outBiTangents), gl.STATIC_DRAW);
        gl.vertexAttribPointer(biTangentAttributeLocation, 3, gl.FLOAT, false, 0, 0);
        gl.enableVertexAttribArray(biTangentAttributeLocation);


    }

    /**
     * Draws a mesh with solid.
     */
    draw()
    {
        this.gl.bindVertexArray(this.vao);
        this.gl.drawElements(this.gl.TRIANGLES, this.nTriangleIndices, this.gl.UNSIGNED_INT, 0);   
    }

    computeTangentFrame(triangles, positions, textureCoordinates)
    {
        const  nVertices = positions.length / 3;
        let tangents = new Array(nVertices);
        let biTangents = new Array(nVertices); 
        for(let vIdx = 0; vIdx < nVertices; vIdx++)
        {
            tangents[vIdx] = new Vec3(0, 0, 0);
            biTangents[vIdx] = new Vec3(0, 0, 0);            
        }

        let nTriangles = triangles.length / 3;
        for(let tIdx = 0; tIdx < nTriangles; tIdx++)
        {
            // Get three vertex indices of triangle.
            let i = Vec3.createFromArray(triangles, tIdx);

            // Get three geometric positions from triangle.
            let p0 = Vec3.createFromArray(positions, i.x);
            let p1 = Vec3.createFromArray(positions, i.y);
            let p2 = Vec3.createFromArray(positions, i.z);

            let u0 = Vec2.createFromArray(textureCoordinates, i.x);
            let u1 = Vec2.createFromArray(textureCoordinates, i.y);
            let u2 = Vec2.createFromArray(textureCoordinates, i.z);

            let s1 = Vec3.sub(p1, p0);
            let s2 = Vec3.sub(p2, p0);

            let u01 = u1.x-u0.x;
            let u02 = u2.x-u0.x;
            let v01 = u1.y-u0.y;
            let v02 = u2.y-u0.y;
            
            let t = Vec3.add(Vec3.scale(v02, s1), Vec3.scale(-v01, s2));
            let b = Vec3.add(Vec3.scale(-u02, s1), Vec3.scale(u01, s2));
            tangents[i.x] = Vec3.add(tangents[i.x], t);
            tangents[i.y] = Vec3.add(tangents[i.y], t);
            tangents[i.z] = Vec3.add(tangents[i.z], t);

            biTangents[i.x] = Vec3.add(biTangents[i.x], b);
            biTangents[i.y] = Vec3.add(biTangents[i.y], b);
            biTangents[i.z] = Vec3.add(biTangents[i.z], b);
        }

        let outTangents = new Float32Array(nVertices * 3);
        let outBiTangents = new Float32Array(nVertices * 3);
        for(let vIdx = 0; vIdx < nVertices; vIdx++)
        {        
            let t = Vec3.normalize(tangents[vIdx]);
            outTangents[vIdx * 3 + 0] = t.x;
            outTangents[vIdx * 3 + 1] = t.y;
            outTangents[vIdx * 3 + 2] = t.z;
            
            let b = Vec3.normalize(biTangents[vIdx]);
            outBiTangents[vIdx * 3 + 0] = b.x;
            outBiTangents[vIdx * 3 + 1] = b.y;
            outBiTangents[vIdx * 3 + 2] = b.z;            
        }
        return {outTangents, outBiTangents};
    }
}
// End Solution
