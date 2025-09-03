package com.eam.mspackagesmanage.controller;

import org.springframework.web.bind.annotation.*;
import com.eam.mspackagesmanage.model.Package;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;

@RestController
@RequestMapping("/packages")
public class PackageController {
    /*
     * private final PackageService packageService;
     * @Autowired
     * public PackageController(PackageService packageService) {
     *     this.packageService = packageService;
     * }
     */

    @GetMapping("/all")
    @Operation(summary = "Get all packages", description = "Returns a list of all registered packages.")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Packages retrieved successfully"),
            @ApiResponse(responseCode = "500", description = "Internal server error")
    })
    public String getAllPackages() {
        return "All packages returned.";
    }

    @GetMapping("/{id}")
    @Operation(summary = "Get package by ID", description = "Returns a specific package based on its ID.")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Package found"),
            @ApiResponse(responseCode = "404", description = "Package not found")
    })
    public String getPackageById(@PathVariable @Parameter(description = "Package ID") String id) {
        return "Package " + id + " returned.";
    }

    @PostMapping("/new")
    @Operation(summary = "Create a new package", description = "Creates a new package with the provided data.")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "201", description = "Package created successfully"),
            @ApiResponse(responseCode = "400", description = "Invalid data")
    })
    public String createPackage(@RequestBody @Parameter(description = "Package data to create") Package pkg) {
        return "Package with tracking number " + pkg.getTrackingNumber() + " created.";
    }

    @PatchMapping("/{id}")
    @Operation(summary = "Update a package", description = "Updates the data of an existing package.")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Package updated successfully"),
            @ApiResponse(responseCode = "404", description = "Package not found")
    })
    public String updatePackage(@PathVariable @Parameter(description = "Package ID") String id,
                                @RequestBody @Parameter(description = "Updated package data") Package pkg) {
        return "Package updated.";
    }

    @DeleteMapping("/{id}")
    @Operation(summary = "Delete a package", description = "Deletes a package based on its ID.")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "204", description = "Package deleted successfully"),
            @ApiResponse(responseCode = "404", description = "Package not found")
    })
    public String deletePackage(@PathVariable @Parameter(description = "Package ID") String id) {
        return "Package deleted.";
    }
}
